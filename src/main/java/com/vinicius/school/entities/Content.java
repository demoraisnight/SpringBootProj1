package com.vinicius.school.entities;

import jakarta.persistence.Entity;

@Entity
public class Content extends Lesson {

    private String textContent;
    private String videoUri;

}