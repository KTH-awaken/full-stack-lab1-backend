package com.example.springbootdocker.View.impl;

import com.example.springbootdocker.View.ViewModels.MessageVm;
import com.example.springbootdocker.View.ViewModels.PatientVm;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.repos.IMessageRepo;
import com.example.springbootdocker.repos.IPatientRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

//    private List<Patient> patientList;
    private IPatientRepo patientRepo;
    private IMessageRepo messageRepo;

    public PatientService(IPatientRepo patientRepo,IMessageRepo messageRepo) {
//        this.patientList = new ArrayList<>();
        this.patientRepo = patientRepo;
        this.messageRepo = messageRepo;

//        Patient patient1 = new Patient("marcus",23,"Best");
//        Patient patient2 = new Patient("hamada",23,"Good");
//
//        patientList.add(patient1);
//        patientList.add(patient2);
    }


    public Optional getPatient(Integer id){
        System.out.println("in get patient");
        System.out.println("id = " + id);
        Optional<Patient> patient = patientRepo.findById(id);

        if (patient.isPresent()) {
            PatientVm patientVm = new PatientVm(patient.get().getId(), patient.get().getName(), patient.get().getAge(), patient.get().getmCondition());
            return Optional.of(patientVm);
        } else {
            return Optional.empty();
        }
    }

    public List<PatientVm> getAllPatients(){
        List<Patient> allPatients = patientRepo.findAll();
        return convetFromPatientListToPatientVMList(allPatients);
    }

    public PatientVm createPatient(PatientVm patientVm){
        Patient patient = convertFromPatientVmToPatient(patientVm);
        System.out.println("patient in service= " + patient);
        patientRepo.save(patient);
        return patientVm;
    }

    private PatientVm convertFromPatientToPatientVM(Patient patient){
         PatientVm patientVm = new PatientVm(patient.getId(),patient.getName(), patient.getAge(), patient.getmCondition());
        return patientVm;
    }
    private Patient convertFromPatientVmToPatient(PatientVm patientVm){
        Patient patient = new Patient(patientVm.getName(), patientVm.getAge(), patientVm.getmCondition());
        return patient;
    }
    private List<PatientVm> convetFromPatientListToPatientVMList(List<Patient> list){
        List<PatientVm> patientVmList = new ArrayList<>();

        for (Patient patient : list) {
            PatientVm patientVm = new PatientVm(patient.getId(),patient.getName(), patient.getAge(), patient.getmCondition());
            patientVmList.add(patientVm);
        }

        return patientVmList;
    }



}
