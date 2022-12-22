package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.dto.User;

@Repository
public class UserRepository {

	private List<User> users = new ArrayList<>();

	public User findUserById(UUID userId) {
		User user = null;
		for (User u : users) {
			if (u.getId().equals(userId)) {
				user = u;
			}
		}
		return user;
	}

	public void save(User user) {
		System.out.println("added user" + user);
		users.add(user);
		System.out.println("User added");

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
