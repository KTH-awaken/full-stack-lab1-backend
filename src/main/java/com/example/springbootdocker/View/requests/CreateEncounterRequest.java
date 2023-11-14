package com.example.springbootdocker.View.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEncounterRequest {
    private int patientId;
    private String doctorEmail;
    private LocalDateTime date;
    private TimeVm time;
    private String title;
    private String details;
}
