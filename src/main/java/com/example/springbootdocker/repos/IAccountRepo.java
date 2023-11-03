package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account,Integer> {
}
