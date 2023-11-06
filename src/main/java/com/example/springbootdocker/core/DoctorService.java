package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.DoctorVm;
import com.example.springbootdocker.View.ViewModels.PatientVm;
import com.example.springbootdocker.entitys.Doctor;
import com.example.springbootdocker.entitys.Patient;
import com.example.springbootdocker.repos.IDoctorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    private IDoctorRepo doctorRepo;

    public DoctorService(IDoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Optional getDoctor(Integer id){
        Optional<Doctor> doctor = doctorRepo.findById(id);

        if (doctor.isPresent()) {
            DoctorVm doctorVm = new DoctorVm(doctor.get().getId(),ConverterUtil.convertFromAccountToAccountVm(doctor.get().getAccount()));
            return Optional.of(doctorVm);
        }
        return Optional.empty();
    }

    public void createDoctor(DoctorVm doctorVm){
        Doctor doctor = ConverterUtil.convertFromDoctorVmToDoctor(doctorVm);
        doctorRepo.save(doctor);
    }
}
