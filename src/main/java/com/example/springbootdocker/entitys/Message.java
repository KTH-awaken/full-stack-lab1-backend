package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    int id;
    private String text;
    private Date date;

//    @ManyToOne
    @JoinColumn(name = "sender")
    private int sender;

//    @ManyToOne
    @JoinColumn(name = "receiver")
    private int receiver;

    public Message(String text, int sender, int receiver) {
//        this.id = generateIntGUID();
        this.text = text;
//        this.date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.date = Date.from(ZonedDateTime.now(ZoneId.of("Europe/Stockholm")).toInstant());

//        this.date = Date.from(Instant.now());
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(int id,String text, int sender, int receiver,Date date) {
        this.id = id;
        this.text = text;
        this.date =date;
        this.sender = sender;
        this.receiver = receiver;
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
        return sender;
    }

    public void setSender(int senderId) {
        this.sender = senderId;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiverId) {
        this.receiver = receiverId;
    }

    //    private int generateIntGUID(){
//        UUID uuid = UUID.randomUUID();
//        long mostSignificantBits = uuid.getMostSignificantBits();
//        int generatedInt = (int) mostSignificantBits;
//        return generatedInt;
//    }

}
