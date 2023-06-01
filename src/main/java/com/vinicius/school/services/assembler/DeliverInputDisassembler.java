package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.DeliverInputDTO;
import com.vinicius.school.entities.Deliver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliverInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;

    public Deliver toDomainObject(DeliverInputDTO deliverInput) {
        return modelMapper.map(deliverInput, Deliver.class);
    }

    public void copyToDomainObject(DeliverInputDTO deliverInput, Deliver deliver) {
        modelMapper.map(deliverInput, deliver);
    }
}
