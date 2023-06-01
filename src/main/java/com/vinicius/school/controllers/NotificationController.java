package com.vinicius.school.controllers;

import com.vinicius.school.dtos.NotificationDTO;
import com.vinicius.school.dtos.inputs.NotificationInputDTO;
import com.vinicius.school.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {
    
    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NotificationDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> insert(@RequestBody NotificationInputDTO notificationInput) {
        NotificationDTO dto = service.insert(notificationInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> update(@PathVariable Long id,
                                              @RequestBody NotificationInputDTO notificationInput) {
        return ResponseEntity.ok().body(service.update(id, notificationInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
