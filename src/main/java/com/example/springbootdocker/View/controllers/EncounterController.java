package com.example.springbootdocker.View.controllers;

import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.View.ViewModels.ObservationVm;
import com.example.springbootdocker.core.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncounterController {

    private EncounterService encounterService;

    @Autowired
    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @PostMapping("/encounter")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEncounter(@RequestBody EncounterVm encounterVm){
        encounterService.createEncounter(encounterVm);
    }

    @PostMapping("/observation")
    @ResponseStatus(HttpStatus.CREATED)
    public void addObservation(@RequestBody ObservationVm observationVm,int encounterId){


    }
}
