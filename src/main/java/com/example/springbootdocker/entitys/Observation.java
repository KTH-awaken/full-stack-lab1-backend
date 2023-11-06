package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class Observation {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String description;
     private Date date;
//    @ManyToOne
    @JoinColumn(name = "patient")
    private int patient;

    public Observation( String description, int patient) {
        this.description = description;
        this.date = Date.from(ZonedDateTime.now(ZoneId.of("Europe/Stockholm")).toInstant());
        this.patient = patient;
//        this.patient = patient;
    }

    public Observation() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPatient() {
        return patient;
    }
}
