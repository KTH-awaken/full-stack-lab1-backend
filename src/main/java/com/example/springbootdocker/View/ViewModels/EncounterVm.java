package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Observation;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncounterVm {
    private int id;
    private int workerId;
    private int patientId;
    private String workerName;
    private String title;
    private String description;
    private Date date;
    private List<Observation> observations;
}
