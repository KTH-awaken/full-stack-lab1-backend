package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.DoctorVm;
import com.example.springbootdocker.View.ViewModels.PatientVm;
import com.example.springbootdocker.entitys.Doctor;
import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.mapper.AccountMapper;
import com.example.springbootdocker.mapper.UserMapper;
import com.example.springbootdocker.repos.IDoctorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService {
    private final IDoctorRepo doctorRepo;
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;


    public Optional getDoctor(Integer id){
        Optional<Doctor> doctor = doctorRepo.findById(id);

        if (doctor.isPresent()) {
            DoctorVm doctorVm = new DoctorVm(doctor.get().getId(),accountMapper.toAccountVM(doctor.get().getAccount()));
            return Optional.of(doctorVm);
        }
        return Optional.empty();
    }

    public List<DoctorVm> getAllDoctors(){
        List<Doctor> allDoctors = doctorRepo.findAll();
        List<DoctorVm> doctorVms = new ArrayList<>();
        for (Doctor d:allDoctors) {
            doctorVms.add(userMapper.toDoctorVM(d));
        }
        return doctorVms;
    }

    public void createDoctor(DoctorVm doctorVm){
        System.out.println("doctorVm = in create doctor" + doctorVm.toString());
        Doctor doctor = userMapper.toDoctor(doctorVm);
        System.out.println("doctor = after convert " + doctor.toString());
        doctorRepo.save(doctor);
    }
}
