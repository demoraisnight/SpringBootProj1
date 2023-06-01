package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.SectionDTO;
import com.vinicius.school.entities.Section;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class SectionModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public SectionDTO toModel(Section section) {
            return modelMapper.map(section, SectionDTO.class);}

    public List<SectionDTO> toCollectionModel(List<Section> sections) {
        return sections.stream().map(section -> toModel(section)).collect(Collectors.toList());
    }

}
