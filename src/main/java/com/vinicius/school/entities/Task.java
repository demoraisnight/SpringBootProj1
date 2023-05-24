package com.vinicius.school.entities;

import jakarta.persistence.Entity;

import java.time.Instant;

@Entity
public class Task extends Lesson {
    private static final long serialVersionUID = 1L;

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight;
    private Instant dueDate;


}