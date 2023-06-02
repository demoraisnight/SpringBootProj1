package com.vinicius.school.controllers;

import com.vinicius.school.dtos.EnrollmentDTO;
import com.vinicius.school.dtos.EnrollmentDTO;
import com.vinicius.school.dtos.EnrollmentPKDTO;
import com.vinicius.school.dtos.inputs.EnrollmentInputDTO;
import com.vinicius.school.entities.Enrollment;
import com.vinicius.school.entities.pk.EnrollmentPK;
import com.vinicius.school.repositories.CourseRepository;
import com.vinicius.school.repositories.EnrollmentRepository;
import com.vinicius.school.repositories.UserRepository;
import com.vinicius.school.services.CourseService;
import com.vinicius.school.services.EnrollmentService;
import com.vinicius.school.services.EnrollmentService;
import com.vinicius.school.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/enrollment")
public class EnrollmentController {
    
    @Autowired
    private EnrollmentService service;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR', 'ROLE_STUDENT')")
    @GetMapping
    public ResponseEntity<Page<EnrollmentDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR', 'ROLE_STUDENT')")
    @GetMapping(value = "/{userId}/{courseId}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Long userId, @PathVariable Long courseId) {
        return ResponseEntity.ok().body(service.findById(userId, courseId));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PostMapping(value = "/{userId}/{courseId}")
    public ResponseEntity<EnrollmentDTO> insert(@PathVariable Long userId, @PathVariable Long courseId) {
        EnrollmentDTO dto = service.insert(userId, courseId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PutMapping(value = "/{userId}/{courseId}/{newUserId}/{newCourseId}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Long userId, @PathVariable Long courseId, @PathVariable Long newUserId, @PathVariable Long newCourseId){
        return ResponseEntity.ok().body(service.update(userId, courseId, newUserId, newCourseId));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PutMapping(value = "/{userId}/{courseId}/activate")
    public ResponseEntity<EnrollmentDTO> activate(@PathVariable Long userId, @PathVariable Long courseId) {
        return ResponseEntity.ok().body(service.activate(userId, courseId));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PatchMapping(value = "/{userId}/{courseId}/activate")
    public ResponseEntity<EnrollmentDTO> deactivate(@PathVariable Long userId, @PathVariable Long courseId) {
        return ResponseEntity.ok().body(service.deactivate(userId, courseId));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @DeleteMapping(value = "/{userId}/{courseId}")
    public ResponseEntity<Void> remove(@PathVariable Long userId, @PathVariable Long courseId) {
        service.deleteById(userId, courseId);
        return ResponseEntity.noContent().build();

    }

    
}