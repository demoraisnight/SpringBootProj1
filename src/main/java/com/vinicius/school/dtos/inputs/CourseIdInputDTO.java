package com.vinicius.school.dtos.inputs;

import javax.validation.constraints.NotBlank;

public class CourseIdInputDTO {

    @NotBlank(message = "Must have a course")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
