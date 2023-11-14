package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Message;
import com.example.springbootdocker.entitys.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVm {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserType userType;
    private List<Message> receivedMessages;
    private List<Message> sentMessages;
}
