package com.vinicius.school.services;

import com.vinicius.school.dtos.UserDTO;
import com.vinicius.school.dtos.inputs.UserInputDTO;
import com.vinicius.school.entities.User;
import com.vinicius.school.repositories.UserRepository;
import com.vinicius.school.services.assembler.UserInputDisassembler;
import com.vinicius.school.services.assembler.UserModelAssembler;
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
import org.springframework.web.bind.annotation.*;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserModelAssembler userModelAssembler;

    @Autowired
    private UserInputDisassembler userInputDisassembler;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> todosUsers = repository.findAll(pageable);
        return new PageImpl<>(userModelAssembler.toCollectionModel(todosUsers.getContent()), pageable,
                todosUsers.getTotalElements());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(@PathVariable Long id) {
        return userModelAssembler.toModel(searchOrThrow(id));
    }

    @Transactional
    public UserDTO insert(@RequestBody UserInputDTO userInput) {
        User user = userInputDisassembler.toDomainObject(userInput);
        user = repository.save(user);
        return userModelAssembler.toModel(user);

    }

    @Transactional
    public UserDTO update(@PathVariable Long id,
                             @RequestBody UserInputDTO userInput) {
        User user = searchOrThrow(id);
        userInputDisassembler.copyToDomainObject(userInput, user);
        user = repository.save(user);
        return userModelAssembler.toModel(user);
    }

    @Transactional
    public void deleteById(@PathVariable Long id) {
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

    public User searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }

}
