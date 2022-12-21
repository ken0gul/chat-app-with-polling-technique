package com.coderscampus.assignment14.dto;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private Long id;
	private String channelName;
	private List<Channel> channels = new ArrayList<>();

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", channelName=" + channelName + ", channels=" + channels + "]";
	}

}
