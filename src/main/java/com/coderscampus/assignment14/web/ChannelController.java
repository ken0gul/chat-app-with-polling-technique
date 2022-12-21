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
import com.coderscampus.assignment14.repository.ChannelRepository;
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
	
		
		model.put("channel", foundChannel);
		// Find the channel
		System.out.println("Found Channel " + foundChannel);
		
		
		
		List<User> allUsers = userService.getUsers();
		model.put("users", allUsers);
		
		
		
		
		List<User> user =allUsers;
		
		
		return "channel";
	}
	
	@GetMapping("/channels/{id}/messages")
	@ResponseBody
	public List<String[]> getChannel2(@PathVariable Long id) {
		Channel channel = channelService.findChannelById(id);
	
		return messageService.getAllMsgs(channel);
	}
	
	
	
	@PostMapping("/channels/{id}")
	@ResponseBody
	public User postMessage(@RequestBody User user, @PathVariable Long id) {
	
			
		Long channelId = user.getChannelId();
		Channel foundChannel = channelService.findChannelById(id);
	

		
		
		
		// get user Id
		UUID userId = user.getId();
		
		User actualUser = userService.findById(userId);
		actualUser.setChannelId(channelId);
//		System.out.println("Found User: " + actualUser);
		actualUser.setMessages(user.getMessages());
		
		// Save message first
		
		
		// Add user to the channel
		foundChannel.addUser(actualUser);
		
		// add channel to the channels
		channelService.saveChannelOnPost(foundChannel);

//		
		messageService.saveMessage(actualUser);
		
		return actualUser;
		
		
	}
}
