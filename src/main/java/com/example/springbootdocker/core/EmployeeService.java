package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.EmployeeVm;
import com.example.springbootdocker.View.ViewModels.EmployeeVm;
import com.example.springbootdocker.entitys.Doctor;
import com.example.springbootdocker.entitys.Employee;
import com.example.springbootdocker.repos.IEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private IEmployeeRepo employeeRepo;

    public EmployeeService(IEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Optional getEmployee(Integer id){
        Optional<Employee> employee = employeeRepo.findById(id);

        if (employee.isPresent()) {
            EmployeeVm employeeVm = new EmployeeVm(employee.get().getId(),ConverterUtil.convertFromAccountToAccountVm(employee.get().getAccount()));
            return Optional.of(employeeVm);
        } else {
            return Optional.empty();
        }
    }

    public void createEmployee(EmployeeVm employeeVm){
        Employee employee = ConverterUtil.convertFromEmployeeVmToEmplyee(employeeVm);
        employeeRepo.save(employee);
    }
}
