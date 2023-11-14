package com.example.springbootdocker.View.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateConditionRequest {
    private String diagnosis;
    private int patientId;
    private String doctorEmail;
}
