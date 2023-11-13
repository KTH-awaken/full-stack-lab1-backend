package com.example.springbootdocker.View.ViewModels;

import java.util.Date;

public class ChatVm {
    int id;
    int otherParticipantId;
    String otherParticipantName;
    String lastMessage;
    private Date date;

    public ChatVm(int id, int otherParticipantId, String otherParticipantName, String lastMessage, Date date) {
        this.id = id;
        this.otherParticipantId = otherParticipantId;
        this.otherParticipantName = otherParticipantName;
        this.lastMessage = lastMessage;
        this.date = date;
    }

    public ChatVm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOtherParticipantId() {
        return otherParticipantId;
    }

    public void setOtherParticipantId(int otherParticipantId) {
        this.otherParticipantId = otherParticipantId;
    }

    public String getOtherParticipantName() {
        return otherParticipantName;
    }

    public void setOtherParticipantName(String otherParticipantName) {
        this.otherParticipantName = otherParticipantName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatVm{" +
                "id=" + id +
                ", otherParticipantId=" + otherParticipantId +
                ", otherParticipantName='" + otherParticipantName + '\'' +
                ", lastMessage='" + lastMessage + '\'' +
                ", date=" + date +
                '}';
    }
}
