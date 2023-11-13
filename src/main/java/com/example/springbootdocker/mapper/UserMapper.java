package com.example.springbootdocker.mapper;


import com.example.springbootdocker.View.ViewModels.DoctorVm;
import com.example.springbootdocker.View.ViewModels.EmployeeVm;
import com.example.springbootdocker.View.ViewModels.PatientVm;
import com.example.springbootdocker.entitys.Doctor;
import com.example.springbootdocker.entitys.Employee;
import com.example.springbootdocker.entitys.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface UserMapper {
    PatientVm toPatientVM(Patient patient);
    Patient toPatient(PatientVm patientVm);
    List<PatientVm> toPatientVMs(List<Patient> patients);
    List<Patient> toPatients(List<PatientVm> patientVms);


    DoctorVm toDoctorVM(Doctor doctor);
    Doctor toDoctor(DoctorVm doctorVm);
    List<DoctorVm> toDoctorVMs(List<Doctor> doctor);
    List<Doctor> toDoctors(List<DoctorVm> doctorVm);


    EmployeeVm toEmployeeVM(Employee employee);
    Employee toEmployee(EmployeeVm employeeVm);
    List<EmployeeVm> toEmployeeVMs(List<Employee> employee);
    List<Employee> toEmployees(List<EmployeeVm> employeeVm);


}
