package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
//    @Column(name = "condition")
    private String mCondition;

    public Patient(int id, String name, int age,String mCondition) {
        this.id = id;//todo läg GUID ist
        this.name = name;
        this.age = age;
        this.mCondition = mCondition;
    }

    public Patient() {

    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
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
