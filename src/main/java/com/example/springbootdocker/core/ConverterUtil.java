package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.*;
import com.example.springbootdocker.entitys.*;
import com.example.springbootdocker.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {

    //Account
    public static Account convertFromAccountVmToAccount(AccountVm accountVm){
        return new Account(
                accountVm.getId(),
                accountVm.getEmail(),
                accountVm.getFirstName(),
                accountVm.getLastName(),
                accountVm.getPassword(),
                accountVm.getUserType(),
                accountVm.getReceivedMessages(),
                accountVm.getSentMessages()
        );

    }
    public static AccountVm convertFromAccountToAccountVm(Account account){
        return new AccountVm(account.getId(),account.getEmail(),account.getFirstName(), account.getLastName() ,account.getPassword(),account.getUserType(),account.getReceivedMessages(),account.getSentMessages());
    }
    //Patient
    public static PatientVm convertFromPatientToPatientVM(Patient patient){
        PatientVm patientVm = new PatientVm(patient.getId(), patient.getmCondition(),ConverterUtil.convertFromAccountToAccountVm(patient.getAccount()));
        return patientVm;
    }
    public static Patient convertFromPatientVmToPatient(PatientVm patientVm){
        Patient patient = new Patient(patientVm.getmCondition(),ConverterUtil.convertFromAccountVmToAccount(patientVm.getAccount()));
        return patient;
    }
    public static List<PatientVm> convertFromPatientListToPatientVMList(List<Patient> list){
        List<PatientVm> patientVmList = new ArrayList<>();

        for (Patient patient : list) {
            PatientVm patientVm = new PatientVm(patient.getId(), patient.getmCondition(),ConverterUtil.convertFromAccountToAccountVm(patient.getAccount()));
            patientVmList.add(patientVm);
        }
        return patientVmList;
    }


    //Message
    public static Message convertFromMessageVmToMessage(MessageVm messageVm){
        return new Message(messageVm.getText(),messageVm.getSender(),messageVm.getReceiver());
    }
    public static MessageVm convertFromMessageToMessageVm(Message message){
        return  new MessageVm(message.getId(), message.getText(), message.getDate(),message.getSender(), message.getReceiver());
    }
    public static List<MessageVm> convertFromMessageToMessageVmList(List<Message> messages){
        List<MessageVm> list = new ArrayList<>();
        for (Message m:messages) {
            list.add(convertFromMessageToMessageVm(m));
        }
        return list;
    }


    public static Doctor convertFromDoctorVmToDoctor(DoctorVm doctorVm) {
        return new Doctor(convertFromAccountVmToAccount(doctorVm.getAccount()));
    }
    public static DoctorVm convertFromDoctorToDoctorVm(Doctor doctor) {
        return new DoctorVm(convertFromAccountToAccountVm(doctor.getAccount()));
    }
    public static Employee convertFromEmployeeVmToEmployee(EmployeeVm employeeVm) {
        return new Employee(convertFromAccountVmToAccount(employeeVm.getAccount()));
    }


    public static EmployeeVm convertFromEmployeeToEmployeeVm(Employee employee) {
        return new EmployeeVm(convertFromAccountToAccountVm(employee.getAccount()));
    }
    //Observation
    public static Observation convertFromObservationVmToObservation(ObservationVm observationVm) {
        return new Observation();
    }
    public static ObservationVm convertFromObservationToObservationVm(Observation observation) {
        return new ObservationVm();
    }
    public static List<ObservationVm> convertFromObservationToObservationVmList(List<Observation> observations){
        List<ObservationVm> observationVms = new ArrayList<>();
        for (Observation o:observations) {
            observationVms.add(convertFromObservationToObservationVm(o));
        }
        return observationVms;
    }
    public static List<Observation> convertFromObservationVmToObservationList(List<ObservationVm> observationVms){
        List<Observation> observations = new ArrayList<>();
        for (ObservationVm ovm : observationVms) {
            observations.add(convertFromObservationVmToObservation(ovm));
        }
        return observations;
    }
    //Encounter
    public static List<Encounter> convertFromEncounterVmToEncounterList(List<EncounterVm> encounterVms){
        List<Encounter> encounters = new ArrayList<>();
        for (EncounterVm evm : encounterVms) {
            encounters.add(convertFromEncounterVmToEncounter(evm));
        }
        return encounters;
    }
    public static Encounter convertFromEncounterVmToEncounter(EncounterVm encounterVm) {
        return new Encounter();
    }


}
