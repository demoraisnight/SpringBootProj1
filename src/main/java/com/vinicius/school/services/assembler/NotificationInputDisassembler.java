package com.vinicius.school.services.assembler;

import com.vinicius.school.dtos.inputs.NotificationInputDTO;
import com.vinicius.school.entities.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;

    public Notification toDomainObject(NotificationInputDTO notificationInput) {
        return modelMapper.map(notificationInput, Notification.class);
    }

    public void copyToDomainObject(NotificationInputDTO notificationInput, Notification notification) {
        modelMapper.map(notificationInput, notification);
    }
}
