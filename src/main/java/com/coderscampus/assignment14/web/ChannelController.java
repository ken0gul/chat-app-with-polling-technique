package com.coderscampus.assignment14.web;

import java.util.List;
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
		
		List<User> users = userService.getUsers();
		
		if(users.isEmpty()) {
			return "redirect:/welcome";
		}
		
		Channel foundChannel = channelService.findChannelById(id);

		model.put("channel", foundChannel);



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
		// Find the current channel
		Long channelId = user.getChannelId();
		Channel foundChannel = channelService.findChannelById(id);

		// Find the current user
		UUID userId = user.getId();
		User actualUser = userService.findById(userId);
		
		// Set the channel id of the user
		actualUser.setChannelId(channelId);
		
		// Set messages
		actualUser.setMessages(user.getMessages());


		// Add user to the channel
		foundChannel.addUser(actualUser);

		// add channel to the channels
		channelService.saveChannelOnPost(foundChannel);

		
		// Save user and its message to the repo
		messageService.saveMessage(actualUser);

		return actualUser;

	}
}
