package com.coderscampus.assignment14.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.dto.Channel;
import com.coderscampus.assignment14.dto.User;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.UserService;

@Controller
public class WelcomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChannelService channelService;
	
	@GetMapping("")
	public String redirect() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		Channel channel = new Channel();
		channel.setChannelName("Channel-1");
		channel.setId(1L);
		Channel savedChannel = channelService.saveChannel(channel);
		
		model.put("channel", savedChannel);
		return "welcome";
	}
	
	@PostMapping("/welcome")
	@ResponseBody
	public User postUsername(@RequestBody User userFromJs) {
		System.out.println(userFromJs);
		UUID id = userFromJs.getId();
		User user = new User();
		user.setUsername(userFromJs.getUsername());
		user.setId(id);
		
		System.out.println("User inside welcome " + user);
		userService.saveUser(user);
		System.out.println(userService.getUsers());
		
		return user;
	}
}
