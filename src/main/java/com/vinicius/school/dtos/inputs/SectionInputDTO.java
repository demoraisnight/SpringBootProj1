package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.Resource;
import com.vinicius.school.entities.Section;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class SectionInputDTO {

    @NotBlank(message = "A section must have a title")
    private String title;
    @NotBlank(message = "A section must have a description")
    private String description;
    @NotBlank(message = "A section must have a position")
    private Integer position;

    private String imgUri;

    @NotBlank(message = "A section must have a resource")
    private ResourceIdInputDTO resource;

    @NotBlank(message = "A section must have a prerequisite")
    private SectionIdInputDTO prerequisite;

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

    public ResourceIdInputDTO getResource() {
        return resource;
    }

    public void setResource(ResourceIdInputDTO resource) {
        this.resource = resource;
    }

    public SectionIdInputDTO getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(SectionIdInputDTO prerequisite) {
        this.prerequisite = prerequisite;
    }
}
