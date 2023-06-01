package com.vinicius.school.services;

import com.vinicius.school.dtos.DeliverDTO;
import com.vinicius.school.dtos.inputs.DeliverInputDTO;
import com.vinicius.school.entities.Deliver;
import com.vinicius.school.repositories.DeliverRepository;
import com.vinicius.school.services.assembler.DeliverInputDisassembler;
import com.vinicius.school.services.assembler.DeliverModelAssembler;
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
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository repository;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private DeliverModelAssembler deliverModelAssembler;

    @Autowired
    private DeliverInputDisassembler deliverInputDisassembler;

    @Transactional(readOnly = true)
    public Page<DeliverDTO> findAll(Pageable pageable) {
        Page<Deliver> todosDelivers = repository.findAll(pageable);
        return new PageImpl<>(deliverModelAssembler.toCollectionModel(todosDelivers.getContent()), pageable,
                todosDelivers.getTotalElements());
    }

    @Transactional(readOnly = true)
    public DeliverDTO findById(Long id) {
        return deliverModelAssembler.toModel(searchOrThrow(id));
    }

    @Transactional
    public DeliverDTO insert(DeliverInputDTO deliverInput, Long userId, Long courseId) {
        Deliver deliver = deliverInputDisassembler.toDomainObject(deliverInput);
        deliver.setEnrollment(enrollmentService.searchOrThrow(userId, courseId));
        deliver.setLesson(lessonService.searchOrThrow(deliver.getLesson().getId()));
        deliver = repository.save(deliver);
        return deliverModelAssembler.toModel(deliver);

    }

    @Transactional
    public DeliverDTO update(Long id,
                            DeliverInputDTO deliverInput, Long userId, Long courseId) {
        Deliver deliver = searchOrThrow(id);
        deliverInputDisassembler.copyToDomainObject(deliverInput, deliver);
        deliver.setEnrollment(enrollmentService.searchOrThrow(userId, courseId));
        deliver.setLesson(lessonService.searchOrThrow(deliver.getLesson().getId()));
        deliver = repository.save(deliver);
        return deliverModelAssembler.toModel(deliver);
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

    public Deliver searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }
}
