package com.vinicius.school.dtos.inputs;


import com.vinicius.school.services.validation.UserInsertValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@UserInsertValid
public class UserInputDTO {

    @NotBlank(message = "A user must have a name")
    private String name;

    @NotBlank(message = "Must have an email")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "A user must have a password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
