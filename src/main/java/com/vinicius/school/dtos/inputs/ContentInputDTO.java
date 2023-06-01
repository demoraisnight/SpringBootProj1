package com.vinicius.school.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

public class ContentInputDTO {

    @NotBlank(message = "Must have a title")
    private String title;

    @NotBlank(message = "Must have a position")
    private Integer position;

    @NotBlank(message = "Must have a section")
    private SectionIdInputDTO section;

    @NotBlank(message = "Must have a text content")
    private String textContent;

    @NotBlank(message = "Must have a video uri")
    private String videoUri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SectionIdInputDTO getSection() {
        return section;
    }

    public void setSection(SectionIdInputDTO section) {
        this.section = section;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}
