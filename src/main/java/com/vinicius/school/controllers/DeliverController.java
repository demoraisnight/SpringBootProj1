package com.vinicius.school.controllers;


import com.vinicius.school.dtos.DeliverDTO;
import com.vinicius.school.dtos.inputs.DeliverInputDTO;
import com.vinicius.school.services.DeliverService;
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
@RequestMapping(value = "/deliveries")
public class DeliverController {
    @Autowired
    private DeliverService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR', 'ROLE_STUDENT')")
    @GetMapping
    public ResponseEntity<Page<DeliverDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeliverDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(value = "/{userId}/{courseId}")
    public ResponseEntity<DeliverDTO> insert(@PathVariable Long userId, @PathVariable Long courseId, @Valid @RequestBody DeliverInputDTO deliverInput) {
        DeliverDTO dto = service.insert(deliverInput, userId, courseId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}/{userId}/{courseId}")
    public ResponseEntity<DeliverDTO> update(@PathVariable Long id, @PathVariable Long userId, @PathVariable Long courseId,
                                           @Valid @RequestBody DeliverInputDTO deliverInput) {
        return ResponseEntity.ok().body(service.update(id, deliverInput, userId, courseId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
