package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Account;
import jakarta.persistence.*;

import java.util.Date;

public class MessageVm {

    int id;
    private String text;
    private Date date;

    private AccountVm sender;
    private AccountVm receiver;

    public MessageVm(int id,String text, Date date, AccountVm sender, AccountVm receiver) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }
    public MessageVm(String text,  AccountVm sender, AccountVm receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

    public MessageVm() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AccountVm getSender() {
        return sender;
    }

    public void setSender(AccountVm sender) {
        this.sender = sender;
    }

    public AccountVm getReceiver() {
        return receiver;
    }

    public void setReceiver(AccountVm receiver) {
        this.receiver = receiver;
    }
}
