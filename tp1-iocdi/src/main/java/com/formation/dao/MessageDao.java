package com.formation.dao;

import java.time.LocalDateTime;

import com.formation.entity.Message;

public interface MessageDao {
	public void save(Message message);

	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime);

	void delete(String user, String toUser);
}