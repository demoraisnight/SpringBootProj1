package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.ResourceDTO;
import com.vinicius.school.entities.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourceModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ResourceDTO toModel(Resource resource) {
        return modelMapper.map(resource, ResourceDTO.class);}

    public List<ResourceDTO> toCollectionModel(List<Resource> resources) {
        return resources.stream().map(resource -> toModel(resource)).collect(Collectors.toList());
    }

}