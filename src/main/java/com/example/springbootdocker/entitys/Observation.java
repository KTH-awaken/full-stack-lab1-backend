package com.example.springbootdocker.entitys;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "observation")
public class Observation {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String description;
     private LocalDateTime date;

     @ManyToOne
     @JoinColumn(name = "encounter_id")
     private Encounter encounter;
}