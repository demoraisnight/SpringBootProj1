package com.vinicius.school.dtos;

import com.vinicius.school.dtos.partials.SectionPartialDTO;
import com.vinicius.school.entities.Task;

public class TaskDTO {

    private Long id;
    private String title;
    private Integer position;
    private SectionPartialDTO section;

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight;


    public TaskDTO() {
    }

    public TaskDTO(Task entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.position = entity.getPosition();
        this.section.setTitle(entity.getSection().getTitle());
        this.section.setPosition(entity.getSection().getPosition());
        this.description = entity.getDescription();
        this.questionCount = entity.getQuestionCount();
        this.approvalCount = entity.getApprovalCount();
        this.weight = entity.getWeight();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getApprovalCount() {
        return approvalCount;
    }

    public void setApprovalCount(Integer approvalCount) {
        this.approvalCount = approvalCount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
