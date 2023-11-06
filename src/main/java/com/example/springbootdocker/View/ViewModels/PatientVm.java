package com.example.springbootdocker.View.ViewModels;

import jakarta.persistence.Id;

import java.util.UUID;

public class PatientVm {
    private int id;

    private String mCondition;
    private AccountVm accountVm;

    public PatientVm( int id, String mCondition,AccountVm accountVm) {
        this.id = id;
        this.mCondition = mCondition;
        this.accountVm = accountVm;
    }

    public PatientVm() {

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


    public AccountVm getAccountVm() {
        return accountVm;
    }

    public void setAccountVm(AccountVm accountVm) {
        this.accountVm = accountVm;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +

                ", mCondition='" + mCondition + '\'' +
                '}';
    }
}
