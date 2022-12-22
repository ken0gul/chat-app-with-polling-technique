package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.dto.Channel;
import com.coderscampus.assignment14.dto.Message;
import com.coderscampus.assignment14.dto.User;

@Repository
public class MessageRepository {

	private List<Message> list = new ArrayList<>();

	public String save(User user) {
		Message message = new Message();

		User actualUser = user;

		String username = actualUser.getUsername();
		List<String> msgs = actualUser.getMessages();
		String[] arr = new String[2];
		arr[0] = username;
		arr[1] = msgs.get(msgs.size() - 1);
		String[] anotherArr = new String[2];
		anotherArr[0] = arr[0];
		anotherArr[1] = arr[1];
		message.addMessages(anotherArr);
		message.setId(user.getChannelId());
		list.add(message);

		return "Message saved";
	}

	public List<Message> findAll() {
		return list;
	}

}
