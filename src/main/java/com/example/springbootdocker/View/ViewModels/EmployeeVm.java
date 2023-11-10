package com.example.springbootdocker.View.ViewModels;

public class EmployeeVm {
    private int id;
    private AccountVm accountVm;

    public EmployeeVm(int id, AccountVm accountVm) {
        this.id = id;
        this.accountVm = accountVm;
    }
    public EmployeeVm(AccountVm accountVm) {
        this.accountVm = accountVm;
    }

    public EmployeeVm() {
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
