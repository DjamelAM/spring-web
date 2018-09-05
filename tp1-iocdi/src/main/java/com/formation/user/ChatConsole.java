package com.formation.user;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.entity.Message;
import com.formation.service.MessageService;

/**
 * Class to make interactions with the user
 */
@Component
public class ChatConsole {
	@Autowired
	private MessageService service;
	private String currentUser = "Djamel";

	public void sendHelloTo(String toUser) {
		// écrit "Hello !" dans le message
		//
		// Message message1 = new Message(currentUser, toUser,
		// MessageFormat.format("Hello {0} !", toUser),
		// LocalDateTime.now());
		// chat.send(message1);

	}

	public void sendGoodbyeTo(String toUser) {
		// écrit "Bye !" dans le message
		Message message1 = new Message(currentUser, toUser, MessageFormat.format("Bye {0} !", toUser),
				LocalDateTime.now());
		// chat.send(message1);
	}

	public void editMessage(String content, Integer idMessage) {
		// édite le contenu du message identifié avec l'id : idMessage
		// Message message = chat.findMessageById(idMessage);
		// message.setMessage(content);
		// message.setEventTime(LocalDateTime.now());
		// chat.edit(message);

	}

	public void deleteMessageToUser(String toUser) {
		// chat.delete(currentUser, toUser);
	}

	public List<Message> findMessageToUserToday(String user) {
		// chat.findMessageSendToAUserADay(user, LocalDate.now());
		return null;// chat.findMessageSendToAUserADay(user, LocalDate.now());

		// Récupère tous les feedbacks du jour pour un user
	}
}