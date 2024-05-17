package com.example.Fun_Blogging.entityDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {
    private int id;
    @NotEmpty
    @Size(min = 4,message = "User Name should be minimum of 4 characters !!")
    private String name;
    @Email(message = "Enter valid Email !!")
    private String email;
    @NotEmpty
    @Size(min = 3,message = "The password is too weak!!")
    private String password;
    @NotEmpty
    private String about;
}
