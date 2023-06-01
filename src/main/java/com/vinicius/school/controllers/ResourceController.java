package com.vinicius.school.controllers;


import com.vinicius.school.dtos.ResourceDTO;
import com.vinicius.school.dtos.inputs.ResourceInputDTO;
import com.vinicius.school.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/resources")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping
    public ResponseEntity<Page<ResourceDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResourceDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> insert(@RequestBody ResourceInputDTO resourceInput) {
        ResourceDTO dto = service.insert(resourceInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceDTO> update(@PathVariable Long id,
                                          @RequestBody ResourceInputDTO resourceInput) {
        return ResponseEntity.ok().body(service.update(id, resourceInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
