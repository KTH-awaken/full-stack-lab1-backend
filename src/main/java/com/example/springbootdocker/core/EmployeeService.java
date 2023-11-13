package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.EmployeeVm;
import com.example.springbootdocker.entitys.Employee;
import com.example.springbootdocker.mapper.AccountMapper;
import com.example.springbootdocker.mapper.UserMapper;
import com.example.springbootdocker.repos.IEmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final IEmployeeRepo employeeRepo;
    private final UserMapper userMapper;


    public EmployeeVm getEmployee(Integer id){
        return userMapper.toEmployeeVM(employeeRepo.getReferenceById(id));
    }
    public List<EmployeeVm> getAllEmployees() {
        return userMapper.toEmployeeVMs(employeeRepo.findAll());
    }

    public void createEmployee(EmployeeVm employeeVm){
        Employee employee = userMapper.toEmployee(employeeVm);
        employeeRepo.save(employee);
    }

}
