package com.vinicius.school.controllers;

import com.vinicius.school.dtos.CourseDTO;
import com.vinicius.school.dtos.inputs.CourseInputDTO;
import com.vinicius.school.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> insert(@Valid @RequestBody CourseInputDTO courseInput) {
        CourseDTO dto = service.insert(courseInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id,
                                          @Valid @RequestBody CourseInputDTO courseInput) {
        return ResponseEntity.ok().body(service.update(id, courseInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
