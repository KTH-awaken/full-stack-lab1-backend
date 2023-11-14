package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IConditionRepo extends JpaRepository<Condition, Integer> {
    List<Condition> findByPatientId(int patientId);
}
