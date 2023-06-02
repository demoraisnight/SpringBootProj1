package com.vinicius.school.controllers;

import com.vinicius.school.dtos.CourseDTO;
import com.vinicius.school.dtos.EnrollmentDTO;
import com.vinicius.school.dtos.inputs.CourseInputDTO;
import com.vinicius.school.services.CourseService;
import com.vinicius.school.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/courses/{id}")
public class CourseEnrollmentController {


    @Autowired
    private CourseService service;

    @Autowired
    private EnrollmentService enrollmentService;
    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @GetMapping(value = "/enrollment")
    public ResponseEntity<Page<EnrollmentDTO>> list(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok().body(enrollmentService.findByIdCourseId(id,pageable));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    @PutMapping(value = "/enrollment/{userId}")
    public ResponseEntity<EnrollmentDTO> enroll(@PathVariable Long id, @PathVariable Long userId) {
        return ResponseEntity.ok().body(enrollmentService.save(id, userId));
    }

}
