package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.UserInputDTO;
import com.vinicius.school.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public User toDomainObject(UserInputDTO userInput) {
        return modelMapper.map(userInput, User.class);
    }

    public void copyToDomainObject(UserInputDTO userInput, User user) {
        modelMapper.map(userInput, user);
    }
}
