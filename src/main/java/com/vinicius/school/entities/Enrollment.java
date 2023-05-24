package com.vinicius.school.entities;

import com.vinicius.school.entities.pk.EnrollmentPK;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    private boolean available;

    @OneToMany(mappedBy = "enrollment")
    private Set<Deliver> deliveries = new HashSet<>();

    @ManyToMany
    private Set<Lesson> lessonsDone = new HashSet<>();

    public Enrollment() {
    }

    public Enrollment(User user, Course course, Instant enrollMoment, boolean available, Set<Deliver> deliveries, Set<Lesson> lessonsDone) {
        id.setUser(user);
        id.setCourse(course);
        this.enrollMoment = enrollMoment;
        this.available = available;
        this.deliveries = deliveries;
        this.lessonsDone = lessonsDone;
    }


    public User getStudent() {
        return id.getUser();
    }

    public void setStudent(User user) {
        id.setUser(user);
    }

    public Course getOffer() {
        return id.getCourse();
    }

    public void setOffer(Course course) {
        id.setCourse(course);
    }

    public EnrollmentPK getId() {
        return id;
    }

    public void setId(EnrollmentPK id) {
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

    public Set<Deliver> getDeliveries() {
        return deliveries;
    }


    public Set<Lesson> getLessonsDone() {
        return lessonsDone;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Enrollment other = (Enrollment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
