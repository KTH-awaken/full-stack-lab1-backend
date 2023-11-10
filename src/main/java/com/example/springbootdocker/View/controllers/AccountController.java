package com.example.springbootdocker.View.controllers;
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
        System.out.println("yo 1");
        System.out.println("accountVm = " + accountVm);
//        AccountVm test=  new AccountVm("TestEmal","testName","Patient","1234");
//        AccountVm test2 = new AccountVm(100,"hej",new ArrayList<>(),new ArrayList<>(),"hej",20);
        return accountService.createAccount(accountVm);
//        return accountService.createAccount(accountVm);
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageVm sendMessage(@RequestBody MessageVm messageVm){
        System.out.println("messageVm = " + messageVm);
        return accountService.sendMessage(messageVm);
    }

    @GetMapping("/message")
    public MessageVm getMessage(@RequestParam Integer id){

        MessageVm messageVm = accountService.getMessage(id);
        return messageVm;
    }

    @GetMapping("/messages")
    public List<MessageVm> getMessages(){
        List<MessageVm> messageVms = accountService.getAllMessages();
        if (!messageVms.isEmpty()){
            return messageVms;
        }
        throw new RuntimeException("no messages found");
    }
}
