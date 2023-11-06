package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEncounterRepo extends JpaRepository<Encounter,Integer> {
}
