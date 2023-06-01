package com.vinicius.school.dtos;

import com.vinicius.school.dtos.partials.UserPartialDTO;

public class CourseDTO{

    private Long id;

    private String name;

    private String imgUri;

    private UserPartialDTO professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public UserPartialDTO getProfessor() {
        return professor;
    }

    public void setProfessor(UserPartialDTO professor) {
        this.professor = professor;
    }
}
