package com.vinicius.school.dtos.partials;



public class ResourcePartialDTO {

    private String title;
    private Integer position;
    private CoursePartialDTO course;

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

    public CoursePartialDTO getCourse() {
        return course;
    }

    public void setCourse(CoursePartialDTO course) {
        this.course = course;
    }
}
