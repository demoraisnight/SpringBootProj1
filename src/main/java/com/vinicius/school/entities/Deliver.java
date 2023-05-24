package com.vinicius.school.entities;

import com.vinicius.school.entities.enums.DeliverStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class Deliver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;
    private Instant moment;
    private DeliverStatus status;
    private String feedback;
    private Integer correcCount;



}
