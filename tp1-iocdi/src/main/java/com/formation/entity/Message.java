package com.formation.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	int id;
	@Column(name = "USER")
	String user;
	@Column(name = "MESSAGE")
	String message;
	@Column(name = "EVENT_TIME")
	LocalDateTime eventTime;
	@Column(name = "TO_USER")
	String toUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime timestamp) {
		// TODO Auto-generated method stub
		this.eventTime = timestamp;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", message=" + message + ", eventTime=" + eventTime
				+ ", toUser=" + toUser + "]";
	}

}
