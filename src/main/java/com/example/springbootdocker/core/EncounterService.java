package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.entitys.Encounter;
import com.example.springbootdocker.repos.IAccountRepo;
import com.example.springbootdocker.repos.IEncounterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EncounterService {
    private final IEncounterRepo encounterRepo;
    private final IAccountRepo accountRepo;


    public List<EncounterVm> getEncounter(){
        List<Encounter> encounters = encounterRepo.findAll();

        List<EncounterVm> vms = new ArrayList<>();

        for(Encounter enc:encounters){
            EncounterVm vm = EncounterVm.builder()
                    .title(enc.getTitle())
                    .description(enc.getDescription())
                    .workerName(accountRepo.getReferenceById(enc.getWorkerId()).getLastName())
                    .workerId(enc.getWorkerId())
                    .patientId(enc.getPatientId())
                    .build();
        }
        System.out.println(encounters);

        return null;
    }

    public void createEncounter(EncounterVm encounterVm){

        Encounter encounter = Encounter.builder()
                .title(encounterVm.getTitle())
                .description(encounterVm.getDescription())
                .date(encounterVm.getDate())
                .observations(new ArrayList<>())
                .workerId(encounterVm.getWorkerId())
                .patientId(encounterVm.getPatientId())
                .build();
        encounterRepo.save(encounter);
    }
}
