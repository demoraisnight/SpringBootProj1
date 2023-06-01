package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.enums.DeliverStatus;
public class DeliverInputDTO {

    private String uri;
    private DeliverStatus status;
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
