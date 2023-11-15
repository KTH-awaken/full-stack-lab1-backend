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
    private String senderFirstName;
    private String senderLastName;
    private String receiverFirstName;
    private String receiverLastName;

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

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    @Override
    public String toString() {
        return "MessageVm{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", senderFirstName='" + senderFirstName + '\'' +
                ", senderLastName='" + senderLastName + '\'' +
                ", receiverFirstName='" + receiverFirstName + '\'' +
                ", receiverLastName='" + receiverLastName + '\'' +
                '}';
    }
}
