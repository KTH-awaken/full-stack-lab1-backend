package com.example.springbootdocker.View.ViewModels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionVm {
    private Long id;
    private FieldUserVm patient;
    private FieldUserVm doctor;
    private LocalDateTime timestamp;
    private String diagnosis;
}
