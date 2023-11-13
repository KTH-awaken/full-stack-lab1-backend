package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.*;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.entitys.UserType;
import com.example.springbootdocker.repos.IAccountRepo;
import com.example.springbootdocker.repos.IMessageRepo;
import org.springframework.stereotype.Service;

import java.util.*;

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

public List<ChatVm> getChats(Integer id) {
    List<Message> messages = messageRepo.findBySenderOrReceiverOrderByDateDesc(id, id);

    Map<Integer, Message> latestMessages = new HashMap<>();
    Map<Integer, String> participantNames = new HashMap<>();
    List<ChatVm> chatVms = new ArrayList<>();

    for (Message message : messages) {
        int otherParticipantId = (message.getSender() == id) ? message.getReceiver() : message.getSender();

        if (!participantNames.containsKey(otherParticipantId)) {
            String otherParticipantName = getParticipantName(otherParticipantId);
            participantNames.put(otherParticipantId, otherParticipantName);
        }

        if (!latestMessages.containsKey(otherParticipantId) || message.getDate().after(latestMessages.get(otherParticipantId).getDate())) {
            latestMessages.put(otherParticipantId, message);
        }
    }

    for (Map.Entry<Integer, Message> entry : latestMessages.entrySet()) {
        int otherParticipantId = entry.getKey();
        Message latestMessage = entry.getValue();
        String otherParticipantName = participantNames.get(otherParticipantId);
        String lastMessage = latestMessage.getText();
        Date date = latestMessage.getDate();

        ChatVm chatVm = new ChatVm(id,otherParticipantId, otherParticipantName, lastMessage, date);
        chatVms.add(chatVm);
    }

    return chatVms;
}
    private String getParticipantName(Integer participantId) {
        Optional<Account> participant = accountRepo.findById(participantId);
        return participant.map(account -> account.getFirstName() + " " + account.getLastName()).orElse("Unknown");
    }

    public List<MessageVm> getChatByParticipantId(Integer myAccountId,Integer participantId) {
        List<Message> messages = messageRepo.findBySenderAndReceiverOrderByDateDesc(myAccountId, participantId);
        System.out.println("messages = " + messages);
        List<MessageVm> messageVms = ConverterUtil.convertFromMessageToMessageVmList(messages);
        System.out.println("messageVms = " + messageVms);
        return messageVms;
    }
}
