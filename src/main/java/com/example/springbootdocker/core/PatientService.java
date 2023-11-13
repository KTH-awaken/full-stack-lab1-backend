package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.PatientVm;
import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.mapper.UserMapper;
import com.example.springbootdocker.repos.IMessageRepo;
import com.example.springbootdocker.repos.IPatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final IPatientRepo patientRepo;
    private final IMessageRepo messageRepo;
    private final UserMapper userMapper;



    public PatientVm getPatient(Integer id){
        return userMapper.toPatientVM(patientRepo.getReferenceById(id));
    }

    public List<PatientVm> getAllPatients(){
        List<Patient> allPatients = patientRepo.findAll();
        System.out.println(allPatients);
        return userMapper.toPatientVMs(allPatients);
    }

    public PatientVm createPatient(PatientVm patientVm){
        Patient patient = userMapper.toPatient(patientVm);
        System.out.println("patient in service= " + patient);
        patientRepo.save(patient);
        return patientVm;
    }

    public PatientVm getPatientById(int id){
        Patient patient = this.patientRepo.getReferenceById(id);
        return userMapper.toPatientVM(patient);
    }





}
