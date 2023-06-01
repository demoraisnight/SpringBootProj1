package com.vinicius.school.controllers;

import com.vinicius.school.dtos.UserDTO;
import com.vinicius.school.dtos.inputs.UserInputDTO;
import com.vinicius.school.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;



@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> list(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInputDTO userInput) {
        UserDTO dto = service.insert(userInput);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update( @PathVariable Long id,
                                           @Valid @RequestBody UserInputDTO userInput) {
        return ResponseEntity.ok().body(service.update(id, userInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
