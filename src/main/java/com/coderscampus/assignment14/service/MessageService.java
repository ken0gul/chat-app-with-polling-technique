package com.coderscampus.assignment14.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.dto.User;
import com.coderscampus.assignment14.repository.MessageRepository;
import com.coderscampus.assignment14.repository.UserRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	
	
	public String saveMessage(User user) {
		return messageRepository.save(user);
	}
	
//	public Map<String, List<String>>  getAllMsgs() {
//		return messageRepository.findAll();
//	}
	public List<String[]>  getAllMsgs() {
		return messageRepository.findAll();
	}
	
	
	public List<String> getOnlyMessages() {
		return messageRepository.getOnlyMessages();
	}
}
