package com.example.springbootdocker.View.controllers;
import com.example.springbootdocker.View.ViewModels.AccountVm;
import com.example.springbootdocker.View.ViewModels.ChatVm;
import com.example.springbootdocker.View.ViewModels.MessageVm;
import com.example.springbootdocker.core.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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
        throw new RuntimeException("No accounts in db");
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
        List<MessageVm> messageVms = accountService.getAllMessages();
        if (!messageVms.isEmpty()){
            return messageVms;
        }
//        throw new RuntimeException("no messages found");
        messageVms.add(new MessageVm("hardcoded return messeg in getmesseges from backend ",1,2));
        System.out.println("getmessegs called");
        return messageVms;
    }

    @GetMapping("/chats")
    public List<ChatVm> getChats(@RequestParam Integer id){
        List<ChatVm> chatVms = accountService.getChats(id);
        if (!chatVms.isEmpty()){
            return chatVms;
        }
        throw new RuntimeException("No chats found in db with user id "+ id);
    }

    @PostMapping("/chat/{myId}/{participantId}")
    public List<MessageVm> getChatByParticipantId(@PathVariable Integer myId, @PathVariable Integer participantId){
        List<MessageVm> messageVms = accountService.getChatByParticipantId(myId,participantId);
        if(!messageVms.isEmpty()){
            return messageVms;
        }
        throw new RuntimeException("no chats with participantId : "+participantId);

    }
}
