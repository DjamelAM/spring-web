package com.formation;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.formation.entity.Message;
import com.formation.service.MessageService;
import com.formation.user.ChatConsole;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) throws IOException {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ChatConsole user = applicationContext.getBean(ChatConsole.class);
		MessageService feedbackToConsole = applicationContext.getBean(MessageService.class);
		Message feedback = new Message("Djamel", "Dylan", "Ouioui", LocalDateTime.now());
		System.out.println(feedbackToConsole.findAllMessages());
		System.out.println(feedbackToConsole.findMessageSendToAUserADay("Dylan", LocalDateTime.of(2018, 8, 29, 0, 0)));

		// user.findMessageToUserToday("Dylan");
		((AbstractApplicationContext) applicationContext).close();
	}
}
