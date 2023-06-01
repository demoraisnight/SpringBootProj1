package com.vinicius.school.dtos.partials;

import com.vinicius.school.entities.Deliver;
import com.vinicius.school.entities.Enrollment;
import com.vinicius.school.entities.Section;
import com.vinicius.school.entities.Topic;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class LessonPartialDTO {

    private String title;
    private Integer position;


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
}
