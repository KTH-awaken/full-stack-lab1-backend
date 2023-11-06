package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.entitys.Encounter;
import com.example.springbootdocker.repos.IEncounterRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncounterService {
    private IEncounterRepo encounterRepo;

    public EncounterService(IEncounterRepo encounterRepo) {
        this.encounterRepo = encounterRepo;
    }

    public Optional getEncounter(Integer id){
        Optional<Encounter> encounter = encounterRepo.findById(id);

        if(encounter.isPresent()){
            EncounterVm encounterVm = new EncounterVm(encounter.get().getId(),encounter.get().getWorkerId(),encounter.get().getPatientId(),encounter.get().getDate(), ConverterUtil.convertFromObservationToObservationVmList(encounter.get().getObservations()));
            return Optional.of(encounterVm);
        }
        return Optional.empty();
    }

    public void createEncounter(EncounterVm encounterVm){
        Encounter encounter = ConverterUtil.convertFromEncounterVmToEncounter(encounterVm);
        encounterRepo.save(encounter);
    }
}
