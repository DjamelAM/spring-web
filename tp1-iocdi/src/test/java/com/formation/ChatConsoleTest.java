package com.formation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.dao.MessageRepository;
import com.formation.user.ChatConsole;

public class ChatConsoleTest {

	public ChatConsoleTest() {
		ChatConsole chatConsole = new ChatConsole();
	}

	@Test
	public void shouldSimulateAConversationBetweenSamAndBob() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ChatConsole chatConsole = applicationContext.getBean(ChatConsole.class);
		MessageRepository feedbackToConsole = applicationContext.getBean(MessageRepository.class);
		// Avoir une interaction avec "sam" (utilisateur courant) et "bob" =
		// hello/goodbye puis "foo"

		chatConsole.sendHelloTo("bob");
		// chatConsole.sendGoodbyeTo("bob");
		// chatConsole.sendHelloTo("foo");
		// chatConsole.sendGoodbyeTo("foo");
		// TODO : Vérifier qu'on a 2 messages avec Bob en destinataire dans la
		// base
		// Modifier l'interaction avec bob :
		chatConsole.editMessage("Big Up bob !", 2);
		// TODO Vérifier qu'on a bien toujours 2 éléments et qu'on a un message
		// avec le contenu "Big Up bob!"
		// Supprimer les interactions avec bob :
		chatConsole.deleteMessageToUser("bob");
		// TODO Vérifier qu'on n' a plus d'interactions avec bob
		// TODO Vérifier ce qui a été dit à foo aujourd'hui : Hello ! et Goodbye
		// !
	}
}
