package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.enums.ResourceType;
import jakarta.validation.constraints.NotBlank;

public class ResourceInputDTO {

    @NotBlank(message = "Must have a title")
    private String title;

    @NotBlank(message = "Must have a description")
    private String description;

    @NotBlank(message = "Must have a position")
    private Long position;
    private Long imgUri;

    @NotBlank(message = "Must have a type")
    private ResourceType type;

    @NotBlank(message = "Must have a course")
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
