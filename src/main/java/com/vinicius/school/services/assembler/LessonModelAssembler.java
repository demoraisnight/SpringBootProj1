package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.LessonDTO;
import com.vinicius.school.entities.Lesson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class LessonModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public LessonDTO toModel(Lesson lesson) {
            return modelMapper.map(lesson, LessonDTO.class);}

    public List<LessonDTO> toCollectionModel(List<Lesson> lessons) {
        return lessons.stream().map(lesson -> toModel(lesson)).collect(Collectors.toList());
    }

}
