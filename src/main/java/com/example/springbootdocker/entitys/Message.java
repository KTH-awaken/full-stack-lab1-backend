package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    int id;
    private String text;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "sender")
    private int senderId;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private int receiverId;

    public Message(String text, int senderId, int receiverId) {
//        this.id = generateIntGUID();
        this.text = text;
        this.date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Message() {

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

    //    private int generateIntGUID(){
//        UUID uuid = UUID.randomUUID();
//        long mostSignificantBits = uuid.getMostSignificantBits();
//        int generatedInt = (int) mostSignificantBits;
//        return generatedInt;
//    }

}
