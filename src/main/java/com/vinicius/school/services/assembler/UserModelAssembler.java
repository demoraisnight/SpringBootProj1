package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.UserDTO;
import com.vinicius.school.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toModel(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toCollectionModel(List<User> users) {
        return users.stream()
                .map(user -> toModel(user))
                .collect(Collectors.toList());
    }
}
