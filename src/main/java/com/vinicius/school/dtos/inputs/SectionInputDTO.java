package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.Resource;
import com.vinicius.school.entities.Section;
import jakarta.persistence.*;

public class SectionInputDTO {


    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceIdInputDTO resource;
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
