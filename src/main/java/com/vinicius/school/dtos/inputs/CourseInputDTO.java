package com.vinicius.school.dtos.inputs;


import javax.validation.constraints.NotBlank;

public class CourseInputDTO {

    @NotBlank(message = "Must have a name")
    private String name;
    private String imgUri;

    @NotBlank(message = "Must have a professor")
    private UserIdInputDTO professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public UserIdInputDTO getProfessor() {
        return professor;
    }

    public void setProfessor(UserIdInputDTO professor) {
        this.professor = professor;
    }
}
