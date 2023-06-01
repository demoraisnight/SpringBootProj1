package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.User;
import jakarta.persistence.*;

import java.time.Instant;

public class NotificationInputDTO {

    private Long id;
    private String text;
    private UserIdInputDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserIdInputDTO getUser() {
        return user;
    }

    public void setUser(UserIdInputDTO user) {
        this.user = user;
    }
}
