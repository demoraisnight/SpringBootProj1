package com.vinicius.school.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

public class LessonIdInputDTO {

    @NotBlank(message = "Must have a lesson")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
