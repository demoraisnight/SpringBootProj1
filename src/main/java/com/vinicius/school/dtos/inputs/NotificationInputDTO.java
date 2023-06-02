package com.vinicius.school.dtos.inputs;

import com.vinicius.school.entities.User;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;

public class NotificationInputDTO {

    @NotBlank(message = "Must have a text")
    private String text;

    @NotBlank(message = "Must have an user")
    private UserIdInputDTO user;

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
