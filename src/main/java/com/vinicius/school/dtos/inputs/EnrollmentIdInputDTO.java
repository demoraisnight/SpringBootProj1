package com.vinicius.school.dtos.inputs;

import javax.validation.constraints.NotBlank;

public class EnrollmentIdInputDTO {

    @NotBlank(message = "Must have an enrollment")
    private Long id;
}
