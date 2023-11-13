package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.ObservationVm;
import com.example.springbootdocker.entitys.Observation;
import com.example.springbootdocker.repos.IObservationRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObservationService {
    private IObservationRepo observationRepo;

    public ObservationService(IObservationRepo observationRepo) {
        this.observationRepo = observationRepo;
    }

    public Optional getObservation(Integer id){
        Optional<Observation> observation = observationRepo.findById(id);

        if(observation.isPresent()){
            ObservationVm observationVm = new ObservationVm();
            return Optional.of(observationVm);
        }
        return Optional.empty();
    }

    public void createObservation(ObservationVm observationVm){
//        Observation observation = ConverterUtil.convertFromObservationVmToObservation(observationVm);
//        observationRepo.save(observation);
    }
}
