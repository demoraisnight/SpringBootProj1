package com.vinicius.school.dtos;

import com.vinicius.school.entities.Enrollment;
import com.vinicius.school.entities.Lesson;
import com.vinicius.school.entities.enums.DeliverStatus;
import jakarta.persistence.*;

import java.time.Instant;

public class DeliverDTO {

    private Long id;
    private String uri;
    private Instant moment;
    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }
}
