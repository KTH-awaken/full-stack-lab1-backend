package com.example.springbootdocker.mapper;


import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.View.ViewModels.ObservationVm;
import com.example.springbootdocker.entitys.Encounter;
import com.example.springbootdocker.entitys.Observation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EncounterMapper {

    ObservationVm toObservationVM (Observation observation);
    List<ObservationVm> toObservationVMs(List<Observation> observations);




    @Mapping(source = "patient.account.firstName", target = "patient.firstName")
    @Mapping(source = "patient.account.lastName", target = "patient.lastName")
    @Mapping(source = "patient.account.email", target = "patient.email")
    @Mapping(source = "doctor.account.firstName", target = "doctor.firstName")
    @Mapping(source = "doctor.account.lastName", target = "doctor.lastName")
    @Mapping(source = "doctor.account.email", target = "doctor.email")
    EncounterVm toEncounterVM(Encounter encounter);

    List<EncounterVm> toEncounterVMs(List<Encounter> encounters);

    Encounter toEncounter(EncounterVm encounterVm);

}
