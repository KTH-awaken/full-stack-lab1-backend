package com.example.springbootdocker.entitys;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    private String mCondition;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;


    @OneToMany(mappedBy = "patient")
    private List<Encounter> encounters;
    @OneToMany(mappedBy = "patient")
    private List<Condition> conditions;

    public Patient( String mCondition,Account account) {
        this.mCondition = mCondition;
        this.account = account;
    }

    public Patient() {

    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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
                ", account=" + account +
                '}';
    }
}
