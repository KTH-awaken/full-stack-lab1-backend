package com.example.springbootdocker.repos;

import com.example.springbootdocker.entitys.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMessageRepo extends JpaRepository<Message,Integer> {
    List<Message> findBySenderOrReceiverOrderByDateDesc(Integer sender, Integer receiver);


//    List<Message> findBySenderAndReceiverOrderByDateDesc(Integer myAccountId, Integer participantId);
@Query("SELECT m FROM Message m WHERE (m.sender = :myAccountId AND m.receiver = :participantId) OR (m.sender = :participantId AND m.receiver = :myAccountId) ORDER BY m.date ASC")
List<Message> findMessagesBetweenTwoPeople(int myAccountId, int participantId);
}
