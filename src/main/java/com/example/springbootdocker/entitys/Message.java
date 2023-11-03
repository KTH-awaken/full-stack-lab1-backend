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
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private Account receiver;

    public Message(String text, Account sender, Account receiver) {
//        this.id = generateIntGUID();
        this.text = text;
        this.date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
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

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    //    private int generateIntGUID(){
//        UUID uuid = UUID.randomUUID();
//        long mostSignificantBits = uuid.getMostSignificantBits();
//        int generatedInt = (int) mostSignificantBits;
//        return generatedInt;
//    }

}
