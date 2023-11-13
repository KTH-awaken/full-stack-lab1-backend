package com.example.springbootdocker.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@Table(name = "encounter")
@AllArgsConstructor
@NoArgsConstructor
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int workerId;
    private int patientId;
    private Date date;
    private String title;
    private String description;


    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
    private List<Observation> observations;


}
