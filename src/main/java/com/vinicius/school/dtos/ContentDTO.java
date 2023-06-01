package com.vinicius.school.dtos;

import com.vinicius.school.dtos.partials.SectionPartialDTO;
import com.vinicius.school.entities.Content;
import com.vinicius.school.entities.Task;

public class ContentDTO {

    private Long id;
    private String title;
    private Integer position;
    private SectionPartialDTO section;

    private String textContent;
    private String videoUri;

    public ContentDTO() {
    }

    public ContentDTO(Content entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.position = entity.getPosition();
        this.section.setTitle(entity.getSection().getTitle());
        this.section.setPosition(entity.getSection().getPosition());
        this.textContent = entity.getTextContent();
        this.videoUri = entity.getVideoUri();
    }

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SectionPartialDTO getSection() {
        return section;
    }

    public void setSection(SectionPartialDTO section) {
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
