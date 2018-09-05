package com.formation.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import org.springframework.jdbc.core.RowMapper;

import com.formation.entity.Message;

public class MessageMapper<T> implements RowMapper<T> {

	@Override
	public T mapRow(ResultSet rs, int arg1) throws SQLException {
		Message message = new Message(null, null, null, null);
		message.setId(rs.getInt("ID"));
		message.setUser(rs.getString("USER"));
		message.setToUser(rs.getString("TO_USER"));
		message.setMessage(rs.getString("MESSAGE"));
		message.setEventTime(((ResultSet) rs).getTimestamp("EVENT_TIME").toInstant().atZone(ZoneId.systemDefault())
				.toLocalDateTime());
		return (T) message;
	}

}
