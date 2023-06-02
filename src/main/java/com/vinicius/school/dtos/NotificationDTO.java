package com.vinicius.school.dtos;

import com.vinicius.school.dtos.partials.UserPartialDTO;
import com.vinicius.school.entities.User;
import javax.persistence.*;

import java.time.Instant;

public class NotificationDTO {


    private Long id;
    private String text;
    private Instant moment;
    private boolean read = false;
    private UserPartialDTO user;

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

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public UserPartialDTO getUser() {
        return user;
    }

    public void setUser(UserPartialDTO user) {
        this.user = user;
    }
}
