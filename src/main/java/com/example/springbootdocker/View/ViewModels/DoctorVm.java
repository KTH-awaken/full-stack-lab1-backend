package com.example.springbootdocker.View.ViewModels;


public class DoctorVm {
    private int id;
    private AccountVm account;

    public DoctorVm(int id, AccountVm accountVm) {
        this.id = id;
        this.account = accountVm;
    }
    public DoctorVm( AccountVm accountVm) {
        this.account = accountVm;
    }

    public DoctorVm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountVm getAccount() {
        return account;
    }

    public void setAccount(AccountVm account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "DoctorVm{" +
                "id=" + id +
                ", account=" + account +
                '}';
    }
}
