package com.example.springbootdocker.service.impl;

import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.repos.impl.IPatientRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private List<Patient> patientList;
    private IPatientRepo patientRepo;

    public PatientService(IPatientRepo patientRepo) {
        this.patientList = new ArrayList<>();
        this.patientRepo = patientRepo;

        Patient patient1 = new Patient(1,"marcus",23,"Best");
        Patient patient2 = new Patient(2,"hamada",23,"Good");

        patientList.add(patient1);
        patientList.add(patient2);
    }

    public Optional<Patient> getPatient(Integer id){
        Optional optional = Optional.empty();
        System.out.println("in get patient");
        System.out.println("id = " + id);
        for (Patient p :patientList) {
            if (p.getId()==id){
                optional=Optional.of(p);
                System.out.println("p = " + p);
                return optional;
            }
        }
        return optional;
    }

    public Patient createPatient(Patient patient){
        System.out.println("patient in service= " + patient);
        return patientRepo.save(patient);
    }
}
