package com.example.springbootdocker.View.controllers;
import com.example.springbootdocker.View.ViewModels.*;
import com.example.springbootdocker.core.AccountService;
import com.example.springbootdocker.core.DoctorService;
import com.example.springbootdocker.core.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;
    private DoctorService doctorService;
    private EmployeeService employeeService;

    @Autowired
    public AccountController(AccountService accountService, DoctorService doctorService, EmployeeService employeeService) {
        this.accountService = accountService;
        this.doctorService = doctorService;
        this.employeeService = employeeService;
    }



    @GetMapping("/account")
    public ResponseEntity<AccountVm> getAccount(@RequestParam Integer id){
        AccountVm accountVm = accountService.getAccount(id);
        return ResponseEntity.ok(accountVm);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountVm>> getAccounts(){
        List<AccountVm> accountVms = accountService.getAllAccounts();
        if(!accountVms.isEmpty()){
            return ResponseEntity.ok(accountVms);
        }
        return ResponseEntity.ok(new ArrayList<>());

    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountVm> createAccount(@RequestBody AccountVm accountVm){
        System.out.println("accountVm = " + accountVm.toString());
        return ResponseEntity.ok(accountService.createAccount(accountVm));
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
        System.out.println("getmessegs called");
        List<MessageVm> messageVms = accountService.getAllMessages();
        if (!messageVms.isEmpty()){
            return messageVms;
        }
        return new ArrayList<>();
    }

    @GetMapping("/chats")
    public List<ChatVm> getChats(@RequestParam Integer id){
        List<ChatVm> chatVms = accountService.getChats(id);
        if (!chatVms.isEmpty()){
            return chatVms;
        }
        return new ArrayList<>();

    }

    @PostMapping("/chat/{myId}/{participantId}")
    public List<MessageVm> getChatByParticipantId(@PathVariable Integer myId, @PathVariable Integer participantId){
        System.out.println("in getChatby paricipanid");
        System.out.println("myId = " + myId);
        System.out.println("participantId = " + participantId);
        List<MessageVm> messageVms = accountService.getChatByParticipantId(myId,participantId);
        if(!messageVms.isEmpty()){
            System.out.println("messageVms = " + messageVms);
            return messageVms;
        }
        return new ArrayList<>();
    }

    @GetMapping("/workers")
    public List<AccountVm> getWorkers(){
        List<AccountVm> workers = new ArrayList<>();
        for (DoctorVm d :doctorService.getAllDoctors()) {
            workers.add(d.getAccount());
        }
        for (EmployeeVm e :employeeService.getAllEmployees()) {
            workers.add(e.getAccount());
        }
        System.out.println("workers called");
        return workers;
    }

}
