package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.EnrollmentDTO;
import com.vinicius.school.entities.Enrollment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnrollmentModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EnrollmentDTO toModel(Enrollment enrollment) {
        return modelMapper.map(enrollment, EnrollmentDTO.class);}

    public List<EnrollmentDTO> toCollectionModel(List<Enrollment> enrollments) {
        return enrollments.stream().map(enrollment -> toModel(enrollment)).collect(Collectors.toList());
    }

}
