package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.LessonInputDTO;
import com.vinicius.school.entities.Lesson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LessonInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;

    public Lesson toDomainObject(LessonInputDTO lessonInput) {
        return modelMapper.map(lessonInput, Lesson.class);
    }

    public void copyToDomainObject(LessonInputDTO lessonInput, Lesson lesson) {
        modelMapper.map(lessonInput, lesson);
    }
}
