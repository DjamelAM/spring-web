package com.formation.model;

import java.time.LocalDateTime;

public class MessageDto {

	String user;
	String message;
	LocalDateTime eventTime;
	String toUser;

	public MessageDto(String user, String toUser, String message, LocalDateTime now) {

		this.user = user;
		this.message = message;
		this.eventTime = now;
		this.toUser = toUser;
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
		return "Message [" + ", user=" + user + ", message=" + message + ", eventTime=" + eventTime + ", toUser="
				+ toUser + "]";
	}
}
