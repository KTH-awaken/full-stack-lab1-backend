package com.example.springbootdocker.View.ViewModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
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
    private List<ObservationVm> observations;
}
