package com.vinicius.school.dtos;

import com.vinicius.school.dtos.partials.SectionPartialDTO;


public class LessonDTO {

    private Long id;
    private String title;
    private Integer position;
    private SectionPartialDTO section;

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
}
