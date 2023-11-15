package com.example.springbootdocker.external.ConditionExternal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionExternal {
    private String patient;
    private String diagnosis;
    private String date;

}
