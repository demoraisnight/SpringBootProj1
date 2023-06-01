package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.enums.ResourceType;

public class ResourceInputDTO {

    private String title;
    private String description;
    private Long position;
    private Long imgUri;
    private ResourceType type;
    private CourseIdInputDTO course;

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

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Long getImgUri() {
        return imgUri;
    }

    public void setImgUri(Long imgUri) {
        this.imgUri = imgUri;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public CourseIdInputDTO getCourse() {
        return course;
    }

    public void setCourse(CourseIdInputDTO course) {
        this.course = course;
    }
}
