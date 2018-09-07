package com.formation.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	public List<Message> findByUser(String fromUser);

	public List<Message> findByUserAndEventTimeBetween(String fromUser, LocalDateTime début, LocalDateTime fin);

	public List<Message> findAllByOrderByEventTimeDesc();
}
