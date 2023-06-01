package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.ResourceInputDTO;
import com.vinicius.school.entities.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Resource toDomainObject(ResourceInputDTO resourceInput) {
        return modelMapper.map(resourceInput, Resource.class);
    }

    public void copyToDomainObject(ResourceInputDTO resourceInput, Resource resource) {
        modelMapper.map(resourceInput, resource);
    }
}