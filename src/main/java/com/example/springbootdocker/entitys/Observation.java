package com.example.springbootdocker.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "observation")
public class Observation {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String description;
     private Date date;

     @ManyToOne
     @JoinColumn(name = "encounter_id")
     private Encounter encounter;


}