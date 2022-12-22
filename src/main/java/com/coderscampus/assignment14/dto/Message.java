package com.coderscampus.assignment14.dto;

import java.util.ArrayList;
import java.util.List;

public class Message {

	private Long id;
	private String message;
	private List<String[]> messages = new ArrayList<>();

	public void addMessages(String[] arr) {
		messages.add(arr);
	}

	public List<String[]> getMessages() {
		return messages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}

}
