package com.vinicius.school.services;

import com.vinicius.school.dtos.NotificationDTO;
import com.vinicius.school.dtos.inputs.NotificationInputDTO;
import com.vinicius.school.entities.Notification;
import com.vinicius.school.repositories.NotificationRepository;
import com.vinicius.school.services.assembler.NotificationInputDisassembler;
import com.vinicius.school.services.assembler.NotificationModelAssembler;
import com.vinicius.school.services.exceptions.DatabaseException;
import com.vinicius.school.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationModelAssembler notificationModelAssembler;

    @Autowired
    private NotificationInputDisassembler notificationInputDisassembler;

    @Transactional(readOnly = true)
    public Page<NotificationDTO> findAll(Pageable pageable) {
        Page<Notification> todosNotifications = repository.findAll(pageable);
        return new PageImpl<>(notificationModelAssembler.toCollectionModel(todosNotifications.getContent()), pageable,
                todosNotifications.getTotalElements());
    }

    @Transactional(readOnly = true)
    public NotificationDTO findById(Long id) {
        return notificationModelAssembler.toModel(searchOrThrow(id));
    }

    @Transactional
    public NotificationDTO insert(NotificationInputDTO notificationInput) {
        Notification notification = notificationInputDisassembler.toDomainObject(notificationInput);
        notification.setUser(userService.searchOrThrow(notificationInput.getUser().getId()));
        notification = repository.save(notification);
        return notificationModelAssembler.toModel(notification);

    }

    @Transactional
    public NotificationDTO update(Long id,
                            NotificationInputDTO notificationInput) {
        Notification notification = searchOrThrow(id);
        notificationInputDisassembler.copyToDomainObject(notificationInput, notification);
        notification.setUser(userService.searchOrThrow(notificationInput.getUser().getId()));
        notification = repository.save(notification);
        return notificationModelAssembler.toModel(notification);
    }

    @Transactional
    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }

    }

    public Notification searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }
}
