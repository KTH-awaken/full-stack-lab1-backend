package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepo extends JpaRepository<Message,Integer> {
}
