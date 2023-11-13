package com.example.springbootdocker.View.controllers;

import com.example.springbootdocker.View.ViewModels.DoctorVm;
import com.example.springbootdocker.core.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor")
    public DoctorVm getDoctor(@RequestParam Integer id){
        Optional doctor = doctorService.getDoctor(id);
        if (doctor.isPresent())return (DoctorVm) doctor.get();

        throw new RuntimeException("No Doctor with id: "+id);
    }

    @GetMapping("/doctors")
    public List<DoctorVm> getDoctors(){
        List<DoctorVm> allDoctors = doctorService.getAllDoctors();
        if (!allDoctors.isEmpty()){
            return allDoctors;
        }
        throw new RuntimeException("No doctors found in db");
    }

    @PostMapping("/doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDoctor(@RequestBody DoctorVm doctorVm){
        doctorService.createDoctor(doctorVm);
    }
}
