package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.NotificationDTO;
import com.vinicius.school.entities.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class NotificationModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public NotificationDTO toModel(Notification notification) {
            return modelMapper.map(notification, NotificationDTO.class);}

    public List<NotificationDTO> toCollectionModel(List<Notification> notifications) {
        return notifications.stream().map(notification -> toModel(notification)).collect(Collectors.toList());
    }

}
