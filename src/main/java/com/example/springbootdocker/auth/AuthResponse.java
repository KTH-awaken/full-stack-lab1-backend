package com.example.springbootdocker.auth;


import com.example.springbootdocker.entitys.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
    private String token;
}
