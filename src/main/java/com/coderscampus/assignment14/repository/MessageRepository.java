package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.dto.User;

@Repository
public class MessageRepository {

	private Map<String, List<String>> messages = new HashMap<>();
	private List<String[]> messageList = new ArrayList<>();
	
//	public String save(User user) {
//		UUID id =user.getId();
//		String username = user.getUsername();
//		List<String> msgs = user.getMessages();
//		messages.put(username, msgs);
//		System.out.println("Message saved in MessageRepo");
//		return "Message saved";
//	}
	public String save(User user) {
		UUID id =user.getId();
		String username = user.getUsername();
		List<String> msgs = user.getMessages();
		String[] arr = new String[2];
		arr[0] = username;
		arr[1] = msgs.get(msgs.size()-1);
		String[] anotherArr = new String[2];
		anotherArr[0]=arr[0];
		anotherArr[1]=arr[1];
		
		messageList.add(anotherArr);
		System.out.println("Message saved in MessageRepo");
		return "Message saved";
	}
	

	

	public  List<String[]> findAll() {
		return messageList;
	}
	
//	public Map<String, List<String>> findAll() {
//		return messages;
//	}
	
	
	public List<String> getOnlyMessages() {
			return messages.entrySet().stream()
								   .map(item -> item.getValue())
								   .map(item -> item.toString())
								   .collect(Collectors.toList());
								   
								   
				
	}
}
