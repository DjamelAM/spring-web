package com.formation.service;

import java.time.LocalDateTime;
import java.util.List;

import com.formation.entity.MessageDto;

/**
 * Interface to give feedback to the user
 *
 */

public interface MessageService {
	void send(MessageDto message1);

	void edit(MessageDto updatedFeedback);

	void delete(String user, String toUser);

	List<MessageDto> findAllMessages();

	List<MessageDto> findMessageSendToAUserADay(String user, LocalDateTime day);

	List<MessageDto> findAllMessageFromUser(String user);

}