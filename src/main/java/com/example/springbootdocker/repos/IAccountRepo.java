package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.entitys.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepo extends JpaRepository<Account,Integer> {
    Optional<Account> findByEmail(String email);
}
