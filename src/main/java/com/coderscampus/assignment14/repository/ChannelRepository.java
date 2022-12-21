package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.dto.Channel;

@Repository
public class ChannelRepository {
	
	private List<Channel> channels = new ArrayList<>();

	public Channel findById(Long id) {
		Channel channel = null;
		for(int i = 0; i < channels.size(); i++) {
			if(channels.get(i).getId().equals(id)) {
				channel= channels.get(i);
			}
		}
		return channel;
		
	}
	
	public Channel save(Channel channel) {
		 channels.add(channel);
		 return channel;
	}
	
	public List<Channel> findAll() {
		return channels;
	}
	
	
	
}
