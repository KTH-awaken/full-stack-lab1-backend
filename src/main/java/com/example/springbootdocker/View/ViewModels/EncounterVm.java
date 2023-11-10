package com.example.springbootdocker.View.ViewModels;

import java.util.Date;
import java.util.List;


public class EncounterVm {
    private int id;
    private int workerId;
    private int patientId;
    private Date date;
    private List<ObservationVm> observationVms;
    //todo läg in titel
    //todo läg name för worker för att visa

    public EncounterVm(int id, int workerId, int patientId, Date date, List<ObservationVm> observationVms) {
        this.id = id;
        this.workerId = workerId;
        this.patientId = patientId;
        this.date = date;
        this.observationVms = observationVms;
    }

    public EncounterVm() {
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

    public List<ObservationVm> getObservationVms() {
        return observationVms;
    }

    public void setObservationVms(List<ObservationVm> observationVms) {
        this.observationVms = observationVms;
    }
}
