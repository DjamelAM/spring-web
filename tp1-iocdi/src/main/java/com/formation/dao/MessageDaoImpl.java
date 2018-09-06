package com.formation.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.formation.entity.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Message message1) {
		message1.setEventTime(LocalDateTime.now());
		em.persist(message1);
	}

	// @Override
	// public List<Message> findAllMessages() {
	//
	// TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m",
	// Message.class);
	// ArrayList<Message> messages = (ArrayList<Message>) query.getResultList();
	// return messages;
	// }
	//
	// @Override
	// public List<Message> findMessages(String user) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public List<Message> findMessagesThisDay(String user, LocalDate day) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public void delete(String user, String toUser) {
		Query query = em.createQuery("DELETE FROM Message m WHERE m.user=:user and m.toUser =: toUser");
		query.setParameter("user", user);
		query.setParameter("toUser", toUser);
		query.executeUpdate();

	}

	@Override
	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime) {
		Query query = em
				.createQuery("UPDATE Message m SET m.message = :message, m.eventTime = :eventTime  WHERE m.id=:id");
		query.setParameter("id", oldMessage.getId());
		query.setParameter("message", newContent);
		query.setParameter("eventTime", newEventTime);
		query.executeUpdate();

	}

}
