package com.vinicius.school.services;

import com.vinicius.school.dtos.ResourceDTO;
import com.vinicius.school.dtos.inputs.ResourceInputDTO;
import com.vinicius.school.entities.Resource;
import com.vinicius.school.repositories.ResourceRepository;
import com.vinicius.school.services.assembler.ResourceInputDisassembler;
import com.vinicius.school.services.assembler.ResourceModelAssembler;
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
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ResourceModelAssembler resourceModelAssembler;

    @Autowired
    private ResourceInputDisassembler resourceInputDisassembler;

    @Transactional(readOnly = true)
    public Page<ResourceDTO> findAll(Pageable pageable) {
        Page<Resource> todosResources = repository.findAll(pageable);
        return new PageImpl<>(resourceModelAssembler.toCollectionModel(todosResources.getContent()), pageable,
                todosResources.getTotalElements());
    }

    @Transactional(readOnly = true)
    public ResourceDTO findById(Long id) {
        return resourceModelAssembler.toModel(searchOrThrow(id));
    }

    @Transactional
    public ResourceDTO insert(ResourceInputDTO resourceInput) {
        Resource resource = resourceInputDisassembler.toDomainObject(resourceInput);
        resource.setCourse(courseService.searchOrThrow(resourceInput.getCourse().getId()));
        resource = repository.save(resource);
        return resourceModelAssembler.toModel(resource);

    }

    @Transactional
    public ResourceDTO update(Long id,
                          ResourceInputDTO resourceInput) {
        Resource resource = searchOrThrow(id);
        resourceInputDisassembler.copyToDomainObject(resourceInput, resource);
        resource.setCourse(courseService.searchOrThrow(resourceInput.getCourse().getId()));
        resource = repository.save(resource);
        return resourceModelAssembler.toModel(resource);
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

    public Resource searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }

}
