package com.coderscampus.assignment14.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.dto.Channel;
import com.coderscampus.assignment14.dto.Message;
import com.coderscampus.assignment14.dto.User;
import com.coderscampus.assignment14.repository.MessageRepository;

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
	public List<String[]>  getAllMsgs(Channel channel) {
		List<Message> list =  messageRepository.findAll();
		List<String[]> l = new ArrayList<>();
		
		list.forEach(item -> {;
			if(item.getId().equals(channel.getId())) {
				l.addAll(item.getMessages());
			}
		});
		return l;
	}
	
	

}
