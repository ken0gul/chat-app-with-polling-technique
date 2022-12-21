package com.coderscampus.assignment14.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.dto.Channel;
import com.coderscampus.assignment14.dto.User;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;
import com.coderscampus.assignment14.service.UserService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private MessageService messageService;
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/channels/{id}")
	
	public String getChannel(@PathVariable Long id, ModelMap model) {
		
		Channel foundChannel = channelService.findChannelById(id);
		List<String> allMessages = messageService.getOnlyMessages();
		model.put("allMsgs", allMessages);
		model.put("channel", foundChannel);
		// Find the channel
		System.out.println("Found Channel " + foundChannel);
		
		
		
		List<User> allUsers = userService.getUsers();
		System.out.println(allUsers);
		model.put("users", allUsers);
		
		
		
		
		List<User> user =allUsers;
		System.out.println("All Users :" + user);
		// Print all the messages
		System.out.println("Print all the messages" + allMessages);
		return "channel";
	}
	
	@GetMapping("/channels/{id}/messages")
	@ResponseBody
	public List<String[]> getChannel2(@PathVariable Long id) {
	
		
		return messageService.getAllMsgs();
	}
	
	
	
	@PostMapping("/channels/{id}")
	@ResponseBody
	public User postMessage(@RequestBody User user, Channel channel) {
		System.out.println("Channel user is in: " + channel);
		System.out.println("User coming from request: " + user);
		UUID id = user.getId();
		
		User actualUser = userService.findById(id);
		System.out.println("Found User: " + actualUser);
		actualUser.setMessages(user.getMessages());
		// Save message
		messageService.saveMessage(actualUser);
		System.out.println(messageService.getAllMsgs());
		
		
		
		return actualUser;
		
	}
}
