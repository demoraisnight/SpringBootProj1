package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.EnrollmentInputDTO;
import com.vinicius.school.entities.Enrollment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;

    public Enrollment toDomainObject(EnrollmentInputDTO enrollmentInput) {
        return modelMapper.map(enrollmentInput, Enrollment.class);
    }

    public void copyToDomainObject(EnrollmentInputDTO enrollmentInput, Enrollment enrollment) {
        modelMapper.map(enrollmentInput, enrollment);
    }
}
