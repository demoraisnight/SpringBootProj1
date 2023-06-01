package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.SectionInputDTO;
import com.vinicius.school.entities.Section;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SectionInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;

    public Section toDomainObject(SectionInputDTO sectionInput) {
        return modelMapper.map(sectionInput, Section.class);
    }

    public void copyToDomainObject(SectionInputDTO sectionInput, Section section) {
        modelMapper.map(sectionInput, section);
    }
}
