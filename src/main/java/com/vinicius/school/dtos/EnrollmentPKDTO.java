package com.vinicius.school.dtos;

import com.vinicius.school.dtos.partials.CoursePartialDTO;
import com.vinicius.school.dtos.partials.UserPartialDTO;
import com.vinicius.school.entities.Course;

public class EnrollmentPKDTO {

    private UserPartialDTO user;

    private CourseDTO course;

    public UserPartialDTO getUser() {
        return user;
    }

    public void setUser(UserPartialDTO user) {
        this.user = user;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
