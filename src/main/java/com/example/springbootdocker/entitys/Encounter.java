package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int workerId;
    private int patientId;
    private Date date;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Observation> observations;

    public Encounter(int workerId, int patientId,  List<Observation> observations) {
        this.workerId = workerId;
        this.patientId = patientId;
        this.date = Date.from(ZonedDateTime.now(ZoneId.of("Europe/Stockholm")).toInstant());
        this.observations = observations;
    }

    public Encounter() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }
}
