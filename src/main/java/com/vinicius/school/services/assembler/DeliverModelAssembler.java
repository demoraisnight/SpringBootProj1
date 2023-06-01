package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.DeliverDTO;
import com.vinicius.school.entities.Deliver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class DeliverModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public DeliverDTO toModel(Deliver deliver) {
            return modelMapper.map(deliver, DeliverDTO.class);}

    public List<DeliverDTO> toCollectionModel(List<Deliver> delivers) {
        return delivers.stream().map(deliver -> toModel(deliver)).collect(Collectors.toList());
    }

}
