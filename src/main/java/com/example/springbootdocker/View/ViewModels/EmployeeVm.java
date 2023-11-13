package com.example.springbootdocker.View.ViewModels;



public class EmployeeVm {
    private int id;
    private AccountVm account;

    public EmployeeVm(int id, AccountVm accountVm) {
        this.id = id;
        this.account = accountVm;
    }
    public EmployeeVm(AccountVm accountVm) {
        this.account = accountVm;
    }

    public EmployeeVm() {
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
}
