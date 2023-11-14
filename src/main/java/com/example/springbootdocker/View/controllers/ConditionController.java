package com.example.springbootdocker.View.controllers;

import com.example.springbootdocker.View.ViewModels.ConditionVm;
import com.example.springbootdocker.View.requests.CreateConditionRequest;
import com.example.springbootdocker.core.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConditionController {
    private final ConditionService conditionService;


    @GetMapping("/condition/{patientId}")
    public List<ConditionVm> getPatientCondition(@PathVariable int patientId){
        return this.conditionService.getPatientConditions(patientId);
    }

    @PostMapping("/condition")
    public ConditionVm createPatientCondition(@RequestBody CreateConditionRequest request){
        return this.conditionService.createCondition(request);
    }
}
