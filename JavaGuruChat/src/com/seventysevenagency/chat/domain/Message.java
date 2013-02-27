package com.seventysevenagency.chat.domain;

public class Message {
	private int id;
	private int conversationId;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int mConversationId) {
		this.conversationId = mConversationId;
	}

}
