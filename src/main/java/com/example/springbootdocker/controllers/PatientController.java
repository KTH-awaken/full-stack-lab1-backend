package com.example.springbootdocker.controllers;

import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping("/patient")
    public Patient getUser(@RequestParam Integer id){
        Optional patient = patientService.getPatient(id);
        System.out.println("patient in controller = " + patient);
        if (patient.isPresent()){
            return (Patient) patient.get();
        }
        //todo returna en vm istllät och thow exception
       throw new RuntimeException("No patient with the id "+id);
    }
//    @PostMapping("/patient")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Patient createPatient(@RequestBody Integer id){
//        //todo remove hårdkodning
//        Patient harCodedPatient = new Patient("milad",33);
//        return patientService.createPatient(harCodedPatient);
//    }

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient){
        //todo remove hårdkodning
        System.out.println("patient in controller = " + patient);
//        Patient harCodedPatient = new Patient(3,"milad",33);
        return patientService.createPatient(patient);
    }


}
