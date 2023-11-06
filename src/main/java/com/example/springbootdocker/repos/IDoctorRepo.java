package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Integer> {
}
