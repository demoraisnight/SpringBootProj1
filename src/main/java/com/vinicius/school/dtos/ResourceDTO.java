package com.vinicius.school.dtos;

import com.vinicius.school.entities.Course;
import com.vinicius.school.entities.Section;
import com.vinicius.school.entities.enums.ResourceType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ResourceDTO {

    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private CourseDTO course;
    private List<SectionDTO> sections = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public List<SectionDTO> getSections() {
        return sections;
    }

    public void setSections(List<SectionDTO> sections) {
        this.sections = sections;
    }
}
