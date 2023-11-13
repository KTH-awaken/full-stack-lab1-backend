package com.example.springbootdocker.mapper;

import com.example.springbootdocker.View.ViewModels.AccountVm;
import com.example.springbootdocker.entitys.Account;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountVm toAccountVM(Account account);
    List<AccountVm> toAccountVMs(List<Account> accountS);

}
