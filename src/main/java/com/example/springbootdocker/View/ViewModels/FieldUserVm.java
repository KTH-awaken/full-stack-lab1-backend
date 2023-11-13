package com.example.springbootdocker.View.ViewModels;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldUserVm {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
