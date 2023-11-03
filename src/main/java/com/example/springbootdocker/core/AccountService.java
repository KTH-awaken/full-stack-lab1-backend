package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.AccountVm;
import com.example.springbootdocker.View.ViewModels.MessageVm;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.repos.IAccountRepo;
import com.example.springbootdocker.repos.IMessageRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private IAccountRepo accountRepo;
    private IMessageRepo messageRepo;

    public AccountService(IAccountRepo accountRepo, IMessageRepo messageRepo) {
        this.accountRepo = accountRepo;
        this.messageRepo = messageRepo;
    }

    public AccountVm getAccount(Integer id){
        java.util.Optional<Account> account = accountRepo.findById(id);
        if (account.isPresent()){
            AccountVm accountVm = new AccountVm(account.get().getId(),account.get().getEmail(),account.get().getReceivedMessages(), account.get().getSentMessages());
            return accountVm;
        }
        throw new RuntimeException("couldn't find account with id: "+id);
    }

    public List<AccountVm> getAllAccounts(){
        List<Account> allAccounts = accountRepo.findAll();
        List<AccountVm> accountVmList = new ArrayList<>();

        for (Account account : allAccounts) {
            AccountVm accountVm =  new AccountVm(account.getId(),account.getEmail(),account.getReceivedMessages(), account.getSentMessages());
            accountVmList.add(accountVm);
        }
        return accountVmList;
    }

    public MessageVm sendMessage(MessageVm messageVm){
        Message message = new Message(messageVm.getText(),messageVm.getSender(),messageVm.getReceiver());
        messageRepo.save(message);
        return messageVm;
    }

    public AccountVm createAccount(AccountVm accountVm){
        Account account = convertFromAccountVmToAccount(accountVm);
        accountRepo.save(account);
        return accountVm;
    }

    public MessageVm getMessage(int id){
        Optional<Message> message = messageRepo.findById(id);
        Message message1 = new Message(message.get().getId(),message.get().getText(),message.get().getSender(),message.get().getReceiver(),message.get().getDate());
        if(message.isPresent()){
            MessageVm messageVm = new MessageVm(message1.getId(), message1.getText(), message1.getDate(),message1.getSender(), message1.getReceiver());
            return messageVm;
        }
        throw new RuntimeException("no message found");

    }

    public List<MessageVm> getAllMessages(){
        List<Message> allMessages = messageRepo.findAll();
        List<MessageVm> messageVmList = new ArrayList<>();

        for (Message message : allMessages) {
            MessageVm messageVm =  new MessageVm(message.getId(), message.getText(), message.getDate(),message.getSender(), message.getReceiver());
            messageVmList.add(messageVm);
        }
        return messageVmList;
    }

    private Account convertFromAccountVmToAccount(AccountVm accountVm){
        return new Account(accountVm.getEmail(),accountVm.getReceivedMessages(),accountVm.getSentMessages());
    }
    private AccountVm convertFromAccountToAccountVm(Account account){
        return new AccountVm(account.getId(),account.getEmail(),account.getReceivedMessages(),account.getSentMessages());
    }
//    private MessageVm fromMessageToMessegeVm(Message message){
//        MessageVm messageVm = new MessageVm(message.getId(), message.getText(), message.getDate(),message.getSender().,message.getReceiver().getId());
//        return messageVm;
//    }

}
