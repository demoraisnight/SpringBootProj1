package com.vinicius.school.controllers;

import com.vinicius.school.dtos.ContentDTO;
import com.vinicius.school.dtos.LessonDTO;
import com.vinicius.school.dtos.TaskDTO;
import com.vinicius.school.dtos.inputs.ContentInputDTO;
import com.vinicius.school.dtos.inputs.LessonInputDTO;
import com.vinicius.school.dtos.inputs.TaskInputDTO;
import com.vinicius.school.services.LessonService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/lessons")
public class LessonController {

    @Autowired
    private LessonService service;

    @GetMapping
    public ResponseEntity<Page<LessonDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PostMapping(value = "/task")
    public ResponseEntity<TaskDTO> insertTask(@Valid @RequestBody TaskInputDTO lessonInput) {
        TaskDTO dto = service.insertTask(lessonInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PostMapping(value = "/content")
    public ResponseEntity<ContentDTO> insertContent(@Valid @RequestBody ContentInputDTO lessonInput) {
        ContentDTO dto = service.insertContent(lessonInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

   // @PutMapping("/{id}/task")
    //public ResponseEntity<LessonDTO> update( @PathVariable Long id,
   //                                        @Valid @RequestBody LessonInputDTO lessonInput) {
   //     return ResponseEntity.ok().body(service.update(id, lessonInput));
  //  }

   // @PutMapping("/{id}/content")
  //  public ResponseEntity<LessonDTO> update( @PathVariable Long id,
   //                                          @Valid @RequestBody LessonInputDTO lessonInput) {
   //     return ResponseEntity.ok().body(service.update(id, lessonInput));
  //  }
   @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
