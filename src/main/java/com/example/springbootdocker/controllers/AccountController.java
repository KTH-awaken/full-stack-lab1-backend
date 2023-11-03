package com.example.springbootdocker.controllers;
import com.example.springbootdocker.View.ViewModels.AccountVm;
import com.example.springbootdocker.View.ViewModels.MessageVm;
import com.example.springbootdocker.core.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public AccountVm getAccount(@RequestParam Integer id){
        AccountVm accountVm = accountService.getAccount(id);
        return accountVm;
    }

    @GetMapping("/accounts")
    public List<AccountVm> getAccounts(){
        List<AccountVm> accountVms = accountService.getAllAccounts();
        if(!accountVms.isEmpty()){
            return accountVms;
        }
        throw new RuntimeException("No accounts in db");
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountVm createAccount(@RequestBody AccountVm accountVm){

//        AccountVm hardcodeVm = new AccountVm("hardocoded@gmai.com",new ArrayList<>(),new ArrayList<>());
        System.out.println("hardcodeVm = " + accountVm);
//        return accountService.createAccount(hardcodeVm);

        return accountService.createAccount(accountVm);
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageVm sendMessage(@RequestBody MessageVm messageVm){
//                AccountVm hardcodeMarcusVm = new AccountVm("MarcusSender@gmai.com",new ArrayList<>(),new ArrayList<>());
//                AccountVm hardcodeHamadaVm = new AccountVm("HamadaReciver@gmai.com",new ArrayList<>(),new ArrayList<>());
//        MessageVm messageVm1 = new MessageVm("An awsom test messege",hardcodeMarcusVm,hardcodeHamadaVm);
//        System.out.println("messageVm1 = " + messageVm1);
        System.out.println("messageVm = " + messageVm);
        return accountService.sendMessage(messageVm);
    }

    @GetMapping("/message")
    public MessageVm getMessage(@RequestParam Integer id){
        MessageVm messageVm = accountService.getMessage(id);
//        System.out.println("messageVm = " + messageVm);
//        AccountVm hardcodeMarcusVm = new AccountVm("acc1n@gmail.com",new ArrayList<>(),new ArrayList<>());
//        AccountVm hardcodeHamadaVm = new AccountVm("acc2n@gmail.com",new ArrayList<>(),new ArrayList<>());
//        MessageVm messageVm1 = new MessageVm("An awsom test messege",hardcodeMarcusVm,hardcodeHamadaVm);
//        return messageVm1;
        return messageVm;
    }
}
