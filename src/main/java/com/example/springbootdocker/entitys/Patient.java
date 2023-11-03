package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    private String name;
    private int age;
    private String mCondition;
    @OneToOne
    private Account account;
//todo remove
//    @OneToMany(mappedBy = "receiver")
//    private List<Message> receivedMessages;
//
//    @OneToMany(mappedBy = "sender")
//    private List<Message> sentMessages;

    public Patient( String name, int age,String mCondition) {
        this.id = generateIntGUID();
        this.name = name;
        this.age = age;
        this.mCondition = mCondition;
    }

    public Patient() {

    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }


    public String getmCondition() {
        return mCondition;
    }

    public void setmCondition(String mCondition) {
        this.mCondition = mCondition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int generateIntGUID(){
        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        int generatedInt = (int) mostSignificantBits;
        System.out.println("generatedInt = " + generatedInt);
        return generatedInt;
    }

//    private void sendMessage()

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mCondition='" + mCondition + '\'' +
                '}';
    }
}
