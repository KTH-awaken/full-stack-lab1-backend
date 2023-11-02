package com.example.springbootdocker.View.impl;

import jakarta.persistence.Id;

import java.util.UUID;

public class PatientVm {
    private int id;
    private String name;
    private int age;
    private String mCondition;

    public PatientVm( int id, String name, int age,String mCondition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mCondition = mCondition;
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
