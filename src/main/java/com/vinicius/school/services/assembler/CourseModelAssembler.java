package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.CourseDTO;
import com.vinicius.school.dtos.UserDTO;
import com.vinicius.school.entities.Course;
import com.vinicius.school.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CourseModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO toModel(Course course) {
            return modelMapper.map(course, CourseDTO.class);}

    public List<CourseDTO> toCollectionModel(List<Course> courses) {
        return courses.stream().map(course -> toModel(course)).collect(Collectors.toList());
    }

}
