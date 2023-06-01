package com.vinicius.school.dtos.inputs;

public class ContentInputDTO {

    private String title;
    private Integer position;
    private SectionIdInputDTO section;


    private String textContent;
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
