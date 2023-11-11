package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.*;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.entitys.UserType;
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
    private PatientService patientService;
    private DoctorService doctorService;
    private EmployeeService employeeService;


    public AccountService(IAccountRepo accountRepo, IMessageRepo messageRepo, PatientService patientService,DoctorService doctorService,EmployeeService employeeService) {
        this.accountRepo = accountRepo;
        this.messageRepo = messageRepo;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.employeeService =employeeService;
    }

    public AccountVm getAccount(Integer id){
        java.util.Optional<Account> account = accountRepo.findById(id);
        if (account.isPresent()){
            AccountVm accountVm = new AccountVm(account.get().getId(),account.get().getEmail(),account.get().getReceivedMessages(), account.get().getSentMessages(),account.get().getFirstName(),account.get().getLastName(),account.get().getAge());
            return accountVm;
        }
        throw new RuntimeException("couldn't find account with id: "+id);
    }

    public List<AccountVm> getAllAccounts(){
        List<Account> allAccounts = accountRepo.findAll();
        List<AccountVm> accountVmList = new ArrayList<>();

        for (Account account : allAccounts) {
            AccountVm accountVm = ConverterUtil.convertFromAccountToAccountVm(account);
            accountVmList.add(accountVm);
        }
        return accountVmList;
    }

    public AccountVm findAccountByEmail(String email){
        return ConverterUtil.convertFromAccountToAccountVm(accountRepo.findByEmail(email));
    }

    public MessageVm sendMessage(MessageVm messageVm){
        Message message = ConverterUtil.convertFromMessageVmToMessage(messageVm);
        messageRepo.save(message);
        return messageVm;
    }

    public AccountVm createAccount(AccountVm accountVm){
        UserType userType = accountVm.getType();
        System.out.println("type  in create acount= " + userType);
        switch (userType){
            case PATIENT: patientService.createPatient(new PatientVm(accountVm));break;
            case DOCTOR: doctorService.createDoctor(new DoctorVm(accountVm));break;
            case EMPLOYEE: employeeService.createEmployee(new EmployeeVm(accountVm));break;
            default: throw new RuntimeException("Incorrect user type : "+ userType);
        }
//        Account account = ConverterUtil.convertFromAccountVmToAccount(accountVm);
//        accountRepo.save(account);
        return accountVm;
    }

    public MessageVm getMessage(int id){
        Optional<Message> message = messageRepo.findById(id);
        Message message1 = new Message(message.get().getId(),message.get().getText(),message.get().getSender(),message.get().getReceiver(),message.get().getDate());
        if(message.isPresent()){
            MessageVm messageVm = ConverterUtil.convertFromMessageToMessageVm(message1);
            return messageVm;
        }
        throw new RuntimeException("no message found");
    }

    public List<MessageVm> getAllMessages(){
        List<Message> allMessages = messageRepo.findAll();
        List<MessageVm> messageVmList = new ArrayList<>();

        for (Message message : allMessages) {
            MessageVm messageVm =  ConverterUtil.convertFromMessageToMessageVm(message);
            messageVmList.add(messageVm);
        }
        return messageVmList;
    }


}
