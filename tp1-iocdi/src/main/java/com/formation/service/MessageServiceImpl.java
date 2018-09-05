package com.formation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.MessageDao;
import com.formation.dao.MessageRepository;
import com.formation.entity.Message;
import com.formation.model.MessageDto;

/**
 * Implementation of {@link IFeedback} using the console as output
 */
@Service
@Transactional
public class MessageServiceImpl extends AbstractFeedback implements MessageService {
	List<Message> feedbacks = new ArrayList<Message>();
	// à utiliser
	// KeyHolder keyHolder = new GeneratedKeyHolder();
	@Autowired
	MessageDao dao;
	@Autowired
	MessageRepository repo;

	@Override
	public void send(MessageDto newFeedback) {

		Message message = convertMessageDtoToMessage(newFeedback);
		dao.save(message);
	}

	@Override
	public void edit(MessageDto updatedFeedback) {
		Message message = convertMessageDtoToMessage(updatedFeedback);
		dao.modify(message, updatedFeedback.getMessage(), updatedFeedback.getEventTime());
	}

	@Override
	public void delete(String user, String toUser) {
		dao.delete(user, toUser);
	}

	@Override
	public List<MessageDto> findAllMessages() {
		List<Message> messages = repo.findAll();
		// on utilise un stream pour ensuite convertir chaque message en
		// messagedto
		Collections.sort(messages, Collections.reverseOrder());
		return messages.stream().map(e -> {
			return convertMessageToMessageDto(e);
		}).collect(Collectors.toList());

	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String user, LocalDateTime day) {
		List<Message> messages = repo.findByUserAndEventTimeBetween(user, day, LocalDateTime.now());
		return messages.stream().map(e -> {
			return convertMessageToMessageDto(e);
		}).collect(Collectors.toList());

	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String user) {
		List<Message> messages = repo.findByUser(user);
		return messages.stream().map(e -> {
			return convertMessageToMessageDto(e);
		}).collect(Collectors.toList());
	}

	private Message convertMessageDtoToMessage(MessageDto messageDto) {
		String newUser = messageDto.getUser();
		String newToUser = messageDto.getToUser();
		String newMessage = messageDto.getMessage();
		LocalDateTime newEventTime = messageDto.getEventTime();
		Message message = new Message(newUser, newToUser, newMessage, newEventTime);
		return message;
	}

	private MessageDto convertMessageToMessageDto(Message message) {
		String newUser = message.getUser();
		String newToUser = message.getToUser();
		String newMessage = message.getMessage();
		LocalDateTime newEventTime = message.getEventTime();
		MessageDto messageDto = new MessageDto(newUser, newToUser, newMessage, newEventTime);
		return messageDto;
	}

}