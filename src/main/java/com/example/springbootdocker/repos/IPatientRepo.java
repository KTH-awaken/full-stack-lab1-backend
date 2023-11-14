package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Doctor;
import com.example.springbootdocker.entitys.Patient;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Integer>{
    List<Patient> findPatientsBymCondition(String mCondition);
    Doctor findPatientByAccountEmail(String email);

}
