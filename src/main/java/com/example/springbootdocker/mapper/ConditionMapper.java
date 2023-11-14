package com.example.springbootdocker.mapper;

import com.example.springbootdocker.View.ViewModels.ConditionVm;
import com.example.springbootdocker.entitys.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConditionMapper {

    @Mapping(source = "patient.account.firstName", target = "patient.firstName")
    @Mapping(source = "patient.account.lastName", target = "patient.lastName")
    @Mapping(source = "patient.account.email", target = "patient.email")
    @Mapping(source = "doctor.account.firstName", target = "doctor.firstName")
    @Mapping(source = "doctor.account.lastName", target = "doctor.lastName")
    @Mapping(source = "doctor.account.email", target = "doctor.email")
    ConditionVm toConditionVM(Condition condition);

    List<ConditionVm> toConditionVMs(List<Condition> conditions);
}
