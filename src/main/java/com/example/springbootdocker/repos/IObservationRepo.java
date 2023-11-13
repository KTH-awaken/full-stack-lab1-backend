package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IObservationRepo extends JpaRepository<Observation,Integer> {
//    List<Observation> findByEncounterId(int encounterId);
}
