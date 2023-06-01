package com.vinicius.school.dtos.inputs;



public class CourseInputDTO {

    private String name;
    private String imgUri;
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
