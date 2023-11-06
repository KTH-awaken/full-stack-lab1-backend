package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
}
