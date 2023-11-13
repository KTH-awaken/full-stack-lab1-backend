package com.example.springbootdocker.View.ViewModels;

import jakarta.persistence.Id;

import java.util.UUID;

public class PatientVm {
    private int id;

    private String mCondition;
    private AccountVm account;

    public PatientVm( int id, String mCondition,AccountVm accountVm) {
        this.id = id;
        this.mCondition = mCondition;
        this.account = accountVm;
    }
    public PatientVm(AccountVm accountVm) {
        this.mCondition = "Default";
        this.account = accountVm;
    }
    public PatientVm() {

    }

    public AccountVm getAccount() {
        return account;
    }

    public void setAccount(AccountVm account) {
        this.account = account;
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




    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +

                ", mCondition='" + mCondition + '\'' +
                '}';
    }
}
