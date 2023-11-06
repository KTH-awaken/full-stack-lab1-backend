package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IObservationRepo extends JpaRepository<Observation,Integer> {
}
