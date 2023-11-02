package com.example.springbootdocker.controllers;

//import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.View.impl.PatientService;
import com.example.springbootdocker.View.impl.PatientVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping("/patient")
    public PatientVm getPatient(@RequestParam Integer id){
        Optional patient = patientService.getPatient(id);
        System.out.println("patient in controller = " + patient);
        if (patient.isPresent()){
            return (PatientVm) patient.get();
        }
        //todo returna en vm istllät och thow exception
       throw new RuntimeException("No patient with the id "+id);
    }

    @GetMapping("/patients")
    public List<PatientVm> getPatients(){
        List<PatientVm> allPatients = patientService.getAllPatients();
        if (!allPatients.isEmpty()){
            return allPatients;
        }
        throw new RuntimeException("No patients in db");
    }


    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientVm createPatient(@RequestBody PatientVm patient){
        //todo remove hårdkodning
        System.out.println("patient in controller = " + patient);
        System.out.println("patient.getId() = " + patient.getId());
        return patientService.createPatient(patient);
    }


}
