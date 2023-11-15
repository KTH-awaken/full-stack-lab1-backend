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
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EncounterController {

    private final EncounterService encounterService;


    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/encounter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EncounterVm> createEncounter(@RequestBody CreateEncounterRequest request){
        return ResponseEntity.ok(encounterService.createEncounter(request));
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/observation")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ObservationVm> addObservation(@RequestBody AddObservationRequest request){
        return ResponseEntity.ok(encounterService.addObservation( request));
    }

    @GetMapping("/encounter")
    public ResponseEntity<List<EncounterVm>> getEncounter(){
        return  ResponseEntity.ok(encounterService.getEncounter());
    }


    @GetMapping("/encounter/{patientId}")
    public ResponseEntity<List<EncounterVm>> getEncounter(@PathVariable int patientId){
//        throw new Exception("This is custom message");
        return ResponseEntity.ok(encounterService.getPatientEncounters(patientId));

    }
}
