package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.entitys.Encounter;
import com.example.springbootdocker.mapper.EncounterMapper;
import com.example.springbootdocker.repos.IAccountRepo;
import com.example.springbootdocker.repos.IEncounterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EncounterService {
    private final IEncounterRepo encounterRepo;
    private final IAccountRepo accountRepo;
    private final EncounterMapper mapper;


    public List<EncounterVm> getEncounter(){
        List<Encounter> encounters = encounterRepo.findAll();
        List<EncounterVm> vms = mapper.toEncounterVMs(encounters);
        for(EncounterVm vm:vms){
            vm.setWorkerName("hamada");
        }
        return vms;
    }

    public void createEncounter(EncounterVm encounterVm){

        Encounter encounter = mapper.toEncounter(encounterVm);
        encounterRepo.save(encounter);
    }

    public List<EncounterVm> getPatientEncounters(int id){
        List<Encounter> encounters = encounterRepo.findByPatientId(id);
        List<EncounterVm> vms = mapper.toEncounterVMs(encounters);
        for(EncounterVm vm:vms){
            vm.setWorkerName("hamada");
        }
        return vms;
    }
}
