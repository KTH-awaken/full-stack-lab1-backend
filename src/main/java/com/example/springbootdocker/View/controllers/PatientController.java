package com.example.springbootdocker.View.controllers;

//import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.core.PatientService;
import com.example.springbootdocker.View.ViewModels.PatientVm;
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
        if (patient.isPresent()){
            return (PatientVm) patient.get();
        }
       throw new RuntimeException("No patient with the id "+id);
    }

    @GetMapping("/patients")
    public List<PatientVm> getPatients(){
        List<PatientVm> allPatients = patientService.getAllPatients();
        return allPatients;
//        if (!allPatients.isEmpty()){
//            return allPatients;
//        }
//        throw new RuntimeException("No patients in db");
    }

    @GetMapping("/patients/{patientId}")
    public PatientVm getPatient(@PathVariable int patientId){
        return patientService.getPatientById(patientId);
    }



    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientVm createPatient(@RequestBody PatientVm patient){
        return patientService.createPatient(patient);
    }


}
