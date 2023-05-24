package com.vinicius.school.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;


    @OneToMany(mappedBy = "lesson")
    private Set<Topic> topics = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private Set<Deliver> deliveries = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_lesson_done",
    joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
            @JoinColumn(name = "user_id"), @JoinColumn(name = "course_id")})
    private Set<Enrollment> enrollmentsDone = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Lesson() {
    }

    public Lesson(Long id, String title, Integer position, Section section) {
        super();
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Set<Topic> getTopics() {
        return topics;
    }


    public Set<Deliver> getDeliveries() {
        return deliveries;
    }

    public Set<Enrollment> getEnrollmentsDone() {
        return enrollmentsDone;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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
        Lesson other = (Lesson) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
