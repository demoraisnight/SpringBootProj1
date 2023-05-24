package com.vinicius.school.entities;

import com.vinicius.school.entities.pk.EnrollmentPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.time.Instant;

@Entity
public class Enrollment {

    @EmbeddedId
    private EnrollmentPK id;

    private Instant enrollMoment;

    private boolean available;

}
