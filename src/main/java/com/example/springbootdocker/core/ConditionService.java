package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.ConditionVm;
import com.example.springbootdocker.View.requests.CreateConditionRequest;
import com.example.springbootdocker.entitys.Condition;
import com.example.springbootdocker.entitys.Doctor;
import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.mapper.ConditionMapper;
import com.example.springbootdocker.repos.IConditionRepo;
import com.example.springbootdocker.repos.IDoctorRepo;
import com.example.springbootdocker.repos.IPatientRepo;
import com.example.springbootdocker.repos.impl.DoctorRepo;
import com.example.springbootdocker.repos.impl.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionService {
    private final IConditionRepo conditionRepo;
    private final ConditionMapper conditionMapper;
    private final IDoctorRepo doctorRepo;
    private final IPatientRepo patientRepo;


    public List<ConditionVm> getPatientConditions(int patientId){
        List<Condition> conditions = this.conditionRepo.findByPatientId(patientId);
        return conditionMapper.toConditionVMs(conditions);
    }

    public ConditionVm createCondition(CreateConditionRequest request){
        Doctor doctor = doctorRepo.findByAccountEmail(request.getDoctorEmail());
        Patient patient = patientRepo.getReferenceById(request.getPatientId());
        LocalDateTime timestamp = LocalDateTime.now();

        Condition conditionToSave = Condition.builder().patient(patient).doctor(doctor).diagnosis(request.getDiagnosis()).timestamp(timestamp).build();
        Condition condition =  conditionRepo.save(conditionToSave);

        doctor.getConditions().add(condition);
        patient.getConditions().add(condition);
        return conditionMapper.toConditionVM(condition);
    }
}
