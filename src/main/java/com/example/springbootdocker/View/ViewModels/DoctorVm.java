package com.example.springbootdocker.View.ViewModels;

public class DoctorVm {
    private int id;
    private AccountVm accountVm;

    public DoctorVm(int id, AccountVm accountVm) {
        this.id = id;
        this.accountVm = accountVm;
    }

    public DoctorVm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountVm getAccountVm() {
        return accountVm;
    }

    public void setAccountVm(AccountVm accountVm) {
        this.accountVm = accountVm;
    }
}
