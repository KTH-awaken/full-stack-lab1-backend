package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Observation;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncounterVm {
    private int id;
    private FieldUserVm patient;
    private FieldUserVm doctor;
    private String title;
    private String description;
    private LocalDateTime date;
    private List<ObservationVm> observations;
}
