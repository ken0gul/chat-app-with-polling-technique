package com.coderscampus.assignment14.dto;

import java.util.UUID;

public class User {
	
	private UUID id = UUID.randomUUID();
	private String username;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
	
	
}
