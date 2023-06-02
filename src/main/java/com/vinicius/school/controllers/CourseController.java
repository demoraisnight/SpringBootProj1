package com.vinicius.school.controllers;

import com.vinicius.school.dtos.CourseDTO;
import com.vinicius.school.dtos.inputs.CourseInputDTO;
import com.vinicius.school.entities.Course;
import com.vinicius.school.services.CourseService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @GetMapping
    public ResponseEntity<Page<CourseDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR', 'ROLE_STUDENT')")
    @GetMapping(value = "/mycourses")
    public ResponseEntity<List<CourseDTO>> listar() {
        return ResponseEntity.ok().body(service.findMyCourses());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PostMapping
    public ResponseEntity<CourseDTO> insert(@Valid @RequestBody CourseInputDTO courseInput) {
        CourseDTO dto = service.insert(courseInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id,
                                          @Valid @RequestBody CourseInputDTO courseInput) {
        return ResponseEntity.ok().body(service.update(id, courseInput));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
