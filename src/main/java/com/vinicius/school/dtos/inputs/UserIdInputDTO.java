package com.vinicius.school.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

public class UserIdInputDTO {

    @NotBlank(message = "Must have an user")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
