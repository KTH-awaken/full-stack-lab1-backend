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
    private String mCondition;
    @OneToOne
    private Account account;

    public Patient( String mCondition,Account account) {
        this.mCondition = mCondition;
        this.account = account;
    }

    public Patient() {

    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public String getmCondition() {
        return mCondition;
    }

    public void setmCondition(String mCondition) {
        this.mCondition = mCondition;
    }


//    private int generateIntGUID(){
//        UUID uuid = UUID.randomUUID();
//        long mostSignificantBits = uuid.getMostSignificantBits();
//        int generatedInt = (int) mostSignificantBits;
//        System.out.println("generatedInt = " + generatedInt);
//        return generatedInt;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +

                ", mCondition='" + mCondition + '\'' +
                '}';
    }
}
