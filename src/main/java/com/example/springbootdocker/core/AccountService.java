package com.example.springbootdocker.core;

import com.example.springbootdocker.View.ViewModels.*;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.entitys.UserType;
import com.example.springbootdocker.mapper.AccountMapper;
import com.example.springbootdocker.repos.IAccountRepo;
import com.example.springbootdocker.repos.IMessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final IAccountRepo accountRepo;
    private final IMessageRepo messageRepo;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final EmployeeService employeeService;
    private final AccountMapper accountMapper;


    public AccountVm getAccount(int id){
        Account account = accountRepo.getReferenceById(id);
        return accountMapper.toAccountVM(account);
    }

    public List<AccountVm> getAllAccounts(){
        return accountMapper.toAccountVMs(accountRepo.findAll());
    }

    public AccountVm findAccountByEmail(String email){
        return accountMapper.toAccountVM(accountRepo.findByEmail(email));
    }

    public MessageVm sendMessage(MessageVm messageVm){
        Message message = ConverterUtil.convertFromMessageVmToMessage(messageVm);
        messageRepo.save(message);
        return messageVm;
    }

    public AccountVm createAccount(AccountVm accountVm){
        UserType userType = accountVm.getUserType();
        System.out.println("type  in create acount= " + userType);
        switch (userType){
            case PATIENT: patientService.createPatient(new PatientVm(accountVm));break;
            case DOCTOR: doctorService.createDoctor(new DoctorVm(accountVm));break;
            case EMPLOYEE: employeeService.createEmployee(new EmployeeVm(accountVm));break;
            default: throw new RuntimeException("Incorrect user type : "+ userType);
        }
        Account acc = accountRepo.findByEmail(accountVm.getEmail());
        accountVm.setId(acc.getId());
        System.out.println("Kollla på denhär acount vMMMMM " + accountVm);
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
            String otherParticipantName = getFirstName(otherParticipantId,"Unknown");
            otherParticipantName.concat(" "+getLastName(otherParticipantId,"unknown"));
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

public List<MessageVm> getChatByParticipantId(Integer myAccountId, Integer participantId) {
    List<Message> messages = messageRepo.findMessagesBetweenTwoPeople(myAccountId, participantId);
    List<MessageVm> messageVms = ConverterUtil.convertFromMessageToMessageVmList(messages);

    Optional<Account> participant = accountRepo.findById(participantId);
    String participantFirstName = participant.map(Account::getFirstName).orElse("Unknown");
    String participantLastName = participant.map(Account::getLastName).orElse("Unknown");

    for (MessageVm messageVm : messageVms) {
        messageVm.setSenderFirstName(getFirstName(messageVm.getSenderId(), participantFirstName));
        messageVm.setSenderLastName(getLastName(messageVm.getSenderId(), participantLastName));
        messageVm.setReceiverFirstName(getFirstName(messageVm.getReceiverId(), participantFirstName));
        messageVm.setReceiverLastName(getLastName(messageVm.getReceiverId(), participantLastName));
    }

    return messageVms;
}

    private String getFirstName(Integer accountId, String defaultName) {
        Optional<Account> account = accountRepo.findById(accountId);
        return account.map(Account::getFirstName).orElse(defaultName);
    }

    private String getLastName(Integer accountId, String defaultName) {
        Optional<Account> account = accountRepo.findById(accountId);
        return account.map(Account::getLastName).orElse(defaultName);
    }



}
