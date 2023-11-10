package com.example.springbootdocker.View.controllers;

import com.example.springbootdocker.View.ViewModels.EmployeeVm;
import com.example.springbootdocker.core.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public EmployeeVm getEmployee(@RequestParam Integer id){
        Optional employee = employeeService.getEmployee(id);
        if (employee.isPresent())return (EmployeeVm) employee.get();

        throw new RuntimeException("No Employee with id: "+id);
    }
    @GetMapping("/employees")
    public List<EmployeeVm> getDoctors(){
        List<EmployeeVm> allEmployees = employeeService.getAllEmployees();
        if (!allEmployees.isEmpty()){
            return allEmployees;
        }
        throw new RuntimeException("No employees found in db");
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeVm employeeVm){
        employeeService.createEmployee(employeeVm);
    }
}
