package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEncounterRepo extends JpaRepository<Encounter,Integer> {
    List<Encounter> findByPatientId(int id);
    List<Encounter> findByPatientAccountEmail(String email);
    List<Encounter> findByDoctorAccountEmail(String email);


}
