package com.example.springbootdocker.View.controllers;

import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.View.ViewModels.ObservationVm;
import com.example.springbootdocker.View.requests.AddObservationRequest;
import com.example.springbootdocker.View.requests.CreateEncounterRequest;
import com.example.springbootdocker.core.EncounterService;
import com.example.springbootdocker.entitys.Encounter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EncounterController {

    private final EncounterService encounterService;


    @PostMapping("/encounter")
    @ResponseStatus(HttpStatus.CREATED)
    public EncounterVm createEncounter(@RequestBody CreateEncounterRequest request){
        return encounterService.createEncounter(request);
    }

    @PostMapping("/observation")
    @ResponseStatus(HttpStatus.CREATED)
    public ObservationVm addObservation(@RequestBody AddObservationRequest request){
        return encounterService.addObservation( request);
    }

    @GetMapping("/encounter")
    public List<EncounterVm> getEncounter(){
        return   this.encounterService.getEncounter();

    }


    @GetMapping("/encounter/{patientId}")
    public List<EncounterVm> getEncounter(@PathVariable int patientId){
        return this.encounterService.getPatientEncounters(patientId);

    }
}
