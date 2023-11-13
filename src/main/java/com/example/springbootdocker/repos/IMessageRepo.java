package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepo extends JpaRepository<Message,Integer> {
    List<Message> findBySenderOrReceiverOrderByDateDesc(Integer sender, Integer receiver);


    List<Message> findBySenderAndReceiverOrderByDateDesc(Integer myAccountId, Integer participantId);
}
