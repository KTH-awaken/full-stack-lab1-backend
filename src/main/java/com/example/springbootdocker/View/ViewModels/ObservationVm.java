package com.example.springbootdocker.View.ViewModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObservationVm {
    private int id;
    private String description;
    private Date date;
    private int patient;
}
