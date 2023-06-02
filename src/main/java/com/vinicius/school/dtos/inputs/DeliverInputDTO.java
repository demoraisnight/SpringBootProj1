package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.enums.DeliverStatus;
import javax.validation.constraints.NotBlank;

public class DeliverInputDTO {

    @NotBlank(message = "Must have an uri")
    private String uri;

    @NotBlank(message = "Must have a status")
    private DeliverStatus status;

    @NotBlank(message = "Must have a lesson")
    private LessonIdInputDTO lesson;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public LessonIdInputDTO getLesson() {
        return lesson;
    }

    public void setLesson(LessonIdInputDTO lesson) {
        this.lesson = lesson;
    }
}
