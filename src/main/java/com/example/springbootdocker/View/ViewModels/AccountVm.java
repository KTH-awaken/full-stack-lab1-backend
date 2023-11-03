package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Message;
import jakarta.persistence.*;

import java.util.List;

public class AccountVm {
    int id;
    private String email;
    private List<Message> receivedMessages;
    private List<Message> sentMessages;

    public AccountVm(int id,String email, List<Message> receivedMessages, List<Message> sentMessages) {
        this.id = id;
        this.email = email;
        this.receivedMessages = receivedMessages;
        this.sentMessages = sentMessages;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}
