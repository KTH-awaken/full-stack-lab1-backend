package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.entitys.UserType;

import java.util.ArrayList;
import java.util.List;

public class AccountVm {
    int id;
    private String email;
    private List<Message> receivedMessages;
    private List<Message> sentMessages;
    private String firstName;
    private String lastName;
    private int age;
    private UserType userType;
    private String password;

    public AccountVm(int id,String email, List<Message> receivedMessages, List<Message> sentMessages,String firstName,String lastName,int age) {
        this.id = id;
        this.email = email;
        this.receivedMessages = receivedMessages;
        this.sentMessages = sentMessages;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public AccountVm(int id, String email, String firstName, String lastName, int age, UserType userType, String password,List<Message>receivedMessages, List<Message> sentMessages) {
        this.id = id;
        this.email = email;
        this.receivedMessages = receivedMessages;
        this.sentMessages = sentMessages;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userType = userType;
        this.password = password;
    }
    public AccountVm(int id, String email, String firstName, String lastName, int age, UserType userType, String password) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userType = userType;
        this.password = password;
    }

    public AccountVm() {
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserType getType() {
        return userType;
    }

    public void setType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountVm{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", receivedMessages=" + receivedMessages +
                ", sentMessages=" + sentMessages +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", type='" + userType + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
