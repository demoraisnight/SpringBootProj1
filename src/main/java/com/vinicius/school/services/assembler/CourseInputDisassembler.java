package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.CourseInputDTO;
import com.vinicius.school.entities.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;

    public Course toDomainObject(CourseInputDTO courseInput) {
        return modelMapper.map(courseInput, Course.class);
    }

    public void copyToDomainObject(CourseInputDTO courseInput, Course course) {
        modelMapper.map(courseInput, course);
    }
}
