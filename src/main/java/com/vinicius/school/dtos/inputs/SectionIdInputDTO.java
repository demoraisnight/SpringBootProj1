package com.vinicius.school.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

public class SectionIdInputDTO {

    @NotBlank(message = "Must have a section")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
