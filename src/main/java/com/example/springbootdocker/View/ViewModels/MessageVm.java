package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Account;
import jakarta.persistence.*;

import java.util.Date;

public class MessageVm {

    int id;
    private String text;
    private Date date;

    private int senderId;
    private int receiverId;

    public MessageVm(int id,String text, Date date, int senderId, int receiverId) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
    public MessageVm(String text,  int senderId, int receiverId) {
        this.text = text;
        this.senderId = senderId;
        this.receiverId = receiverId;
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

    public int getSender() {
        return senderId;
    }

    public void setSender(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiver() {
        return receiverId;
    }

    public void setReceiver(int receiverId) {
        this.receiverId = receiverId;
    }
}
