package com.vinicius.school.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

public class ResourceIdInputDTO {

    @NotBlank(message = "Must have a resource")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
