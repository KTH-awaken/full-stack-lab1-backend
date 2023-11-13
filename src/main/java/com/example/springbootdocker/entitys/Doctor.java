package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;


    public Doctor(Account account) {
        this.account = account;
    }

    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", account=" + account +
                '}';
    }
}
