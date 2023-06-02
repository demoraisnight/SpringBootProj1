package com.vinicius.school.dtos.updates;

import com.vinicius.school.services.validation.UserUpdateValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@UserUpdateValid
public class UserUpdateInputDTO {

    @NotBlank(message = "A user must have a name")
    private String name;

    @NotBlank(message = "Must have an email")
    @Email(message = "Must be a valid email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
