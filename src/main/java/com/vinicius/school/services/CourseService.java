package com.vinicius.school.services;

import com.vinicius.school.dtos.CourseDTO;
import com.vinicius.school.dtos.inputs.CourseInputDTO;
import com.vinicius.school.entities.Course;
import com.vinicius.school.repositories.CourseRepository;
import com.vinicius.school.services.assembler.CourseInputDisassembler;
import com.vinicius.school.services.assembler.CourseModelAssembler;
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
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseModelAssembler CourseModelAssembler;

    @Autowired
    private CourseInputDisassembler CourseInputDisassembler;

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<Course> todosCourses = repository.findAll(pageable);
        return new PageImpl<>(CourseModelAssembler.toCollectionModel(todosCourses.getContent()), pageable,
                todosCourses.getTotalElements());
    }

    @Transactional(readOnly = true)
    public CourseDTO findById(@PathVariable Long id) {
        return CourseModelAssembler.toModel(searchOrThrow(id));
    }

    @Transactional
    public CourseDTO insert(@RequestBody CourseInputDTO courseInput) {
        Course course = CourseInputDisassembler.toDomainObject(courseInput);
        course.setProfessor(userService.searchOrThrow(courseInput.getProfessor().getId()));
        course = repository.save(course);
        return CourseModelAssembler.toModel(course);

    }

    @Transactional
    public CourseDTO update(@PathVariable Long id,
                          @RequestBody CourseInputDTO CourseInput) {
        Course Course = searchOrThrow(id);
        CourseInputDisassembler.copyToDomainObject(CourseInput, searchOrThrow(id));
        Course = repository.save(Course);
        return CourseModelAssembler.toModel(Course);
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

    public Course searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }

}
