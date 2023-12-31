package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.View.ViewModels.ObservationVm;
import com.example.springbootdocker.View.requests.AddObservationRequest;
import com.example.springbootdocker.View.requests.CreateEncounterRequest;
import com.example.springbootdocker.entitys.*;
import com.example.springbootdocker.mapper.EncounterMapper;
import com.example.springbootdocker.repos.*;
import com.example.springbootdocker.repos.impl.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EncounterService {
    private final IEncounterRepo encounterRepo;
    private final IAccountRepo accountRepo;
    private final IObservationRepo observationRepo;
    private final IDoctorRepo doctorRepo;
    private final IPatientRepo patientRepo;
    private final EncounterMapper mapper;


    public List<EncounterVm> getEncounter(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        Account account = accountRepo.findByEmail(username);
        if (account == null) return new ArrayList<>();
        List<Encounter> encounters;
        switch (account.getUserType()){
            case PATIENT -> encounters = encounterRepo.findByPatientAccountEmail(username);
            case DOCTOR -> encounters = encounterRepo.findByDoctorAccountEmail(username);
            default -> encounters = new ArrayList<>();
        }
        return mapper.toEncounterVMs(encounters);
    }

    public EncounterVm createEncounter(CreateEncounterRequest request){
        int year = request.getDate().getYear();
        int month = request.getDate().getMonthValue();
        int day = request.getDate().getDayOfMonth();
        int hour = request.getTime().getHour();
        int minute = request.getTime().getMinute();

        Doctor doctor = doctorRepo.findByAccountEmail(request.getDoctorEmail());
        Patient patient = patientRepo.getReferenceById(request.getPatientId());

        LocalDateTime date = LocalDateTime.of(year,month,day,hour,minute);
        Encounter encounter = Encounter
                .builder()
                .title(request.getTitle())
                .description(request.getDetails())
                .patient(patient)
                .doctor(doctor)
                .date(date)
                .observations(new ArrayList<>())
                .build();

        return mapper.toEncounterVM(encounterRepo.save(encounter));
    }

    public List<EncounterVm> getPatientEncounters(int id){
        List<Encounter> encounters = encounterRepo.findByPatientId(id);
        return mapper.toEncounterVMs(encounters);
    }

    public ObservationVm addObservation(AddObservationRequest request){
        Encounter enc = encounterRepo.getReferenceById(request.getEncounterId());
        Observation obsToSave = Observation.builder().encounter(enc).description(request.getContent()).date(LocalDateTime.now()).build();
        Observation observation = observationRepo.save(obsToSave);
        return mapper.toObservationVM(observation);

    }
}
