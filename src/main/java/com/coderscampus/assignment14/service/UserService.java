package com.coderscampus.assignment14.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.dto.User;
import com.coderscampus.assignment14.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public void saveUser(User user) {
		userRepository.save(user);
		
	}
	
	public Set<User> getUsers() {
		return userRepository.getUsers();
	}
	
}
