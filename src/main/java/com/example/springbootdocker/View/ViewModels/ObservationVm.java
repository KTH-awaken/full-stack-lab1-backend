package com.example.springbootdocker.View.ViewModels;

import java.util.Date;


public class ObservationVm {
    private int id;
    private String description;
    private Date date;
    private int patient;

    public ObservationVm(int id, String description, Date date, int patient) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.patient = patient;
    }

    public ObservationVm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPatient(int patient) {
        this.patient = patient;
    }
}
