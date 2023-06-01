package com.vinicius.school.controllers;

import com.vinicius.school.dtos.SectionDTO;
import com.vinicius.school.dtos.inputs.SectionInputDTO;
import com.vinicius.school.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/sections")
public class SectionController {

    @Autowired
    private SectionService service;

    @GetMapping
    public ResponseEntity<Page<SectionDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SectionDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SectionDTO> insert(@RequestBody SectionInputDTO sectionInput) {
        SectionDTO dto = service.insert(sectionInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionDTO> update(@PathVariable Long id,
                                              @RequestBody SectionInputDTO sectionInput) {
        return ResponseEntity.ok().body(service.update(id, sectionInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
