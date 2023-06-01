package com.vinicius.school.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

public class TaskInputDTO {

    @NotBlank(message = "A task must have a title")
    private String title;
    @NotBlank(message = "A task must have a position")
    private Integer position;
    @NotBlank(message = "A task must have a section")
    private SectionIdInputDTO section;

    @NotBlank(message = "A task must have a description")
    private String description;
    @NotBlank(message = "A task must have a question count")
    private Integer questionCount;
    @NotBlank(message = "A task must have an approval count")
    private Integer approvalCount;
    @NotBlank(message = "A task must have a weight")
    private Double weight;

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
