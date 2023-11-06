package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.PatientVm;
import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.repos.IMessageRepo;
import com.example.springbootdocker.repos.IPatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private IPatientRepo patientRepo;
    private IMessageRepo messageRepo;

    public PatientService(IPatientRepo patientRepo,IMessageRepo messageRepo) {
        this.patientRepo = patientRepo;
        this.messageRepo = messageRepo;

    }


    public Optional getPatient(Integer id){
        Optional<Patient> patient = patientRepo.findById(id);

        if (patient.isPresent()) {
            PatientVm patientVm = new PatientVm(patient.get().getId(), patient.get().getmCondition(),ConverterUtil.convertFromAccountToAccountVm(patient.get().getAccount()));
            return Optional.of(patientVm);
        } else {
            return Optional.empty();
        }
    }

    public List<PatientVm> getAllPatients(){
        List<Patient> allPatients = patientRepo.findAll();
        return ConverterUtil.convertFromPatientListToPatientVMList(allPatients);
    }

    public PatientVm createPatient(PatientVm patientVm){
        Patient patient = ConverterUtil.convertFromPatientVmToPatient(patientVm);
        System.out.println("patient in service= " + patient);
        patientRepo.save(patient);
        return patientVm;
    }





}
