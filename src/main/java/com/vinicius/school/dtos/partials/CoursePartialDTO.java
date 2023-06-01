package com.vinicius.school.dtos.partials;

public class CoursePartialDTO {

    private String name;
    private UserPartialDTO professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserPartialDTO getProfessor() {
        return professor;
    }

    public void setProfessor(UserPartialDTO professor) {
        this.professor = professor;
    }
}
