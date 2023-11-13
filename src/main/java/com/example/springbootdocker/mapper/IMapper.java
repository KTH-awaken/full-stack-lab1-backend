package com.example.springbootdocker.mapper;


import com.example.springbootdocker.View.ViewModels.EncounterVm;
import com.example.springbootdocker.View.ViewModels.ObservationVm;
import com.example.springbootdocker.entitys.Encounter;
import com.example.springbootdocker.entitys.Observation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapper {
    ObservationVm toObservationVM (Observation observation);
    List<ObservationVm> toObservationVMs(List<Observation> observations);



    Encounter toEncounter(EncounterVm encounterVm);


    Encounter toEncounterVM(EncounterVm encounterVm);

    List<EncounterVm> toEncounterVMs(List<Encounter> encounters);
}
