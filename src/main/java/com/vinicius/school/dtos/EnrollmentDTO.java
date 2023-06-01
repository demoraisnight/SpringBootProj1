package com.vinicius.school.dtos;

import com.vinicius.school.entities.Enrollment;

import java.time.Instant;


public class EnrollmentDTO {

    private EnrollmentPKDTO id;

    private Instant enrollMoment;

    private boolean available;


    public EnrollmentPKDTO getId() {
        return id;
    }

    public void setId(EnrollmentPKDTO id) {
        this.id = id;
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
