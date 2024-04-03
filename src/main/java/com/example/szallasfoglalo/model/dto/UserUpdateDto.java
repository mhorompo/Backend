package com.example.szallasfoglalo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserUpdateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String oldPass;
}