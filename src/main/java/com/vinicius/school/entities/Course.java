package com.vinicius.school.entities;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imgUri;

    @OneToMany(mappedBy = "course")
    private Set<Resource> resource = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Topic> topics = new HashSet<>();

    // professor here -> Many to One(or zero)...
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User professor;

    public Course() {
    }
    public Course(Long id, String name, String imgUri, User professor) {
        super();
        this.id = id;
        this.name = name;
        this.imgUri = imgUri;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public Set<Resource> getResource() {
        return resource;
    }


    public Set<Topic> getTopics() {
        return topics;
    }

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
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
        Course other = (Course) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
