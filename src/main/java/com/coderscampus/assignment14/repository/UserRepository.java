package com.coderscampus.assignment14.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.dto.User;

@Repository
public class UserRepository {

	
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
