package com.seventysevenagency.chat.domain;

public class Message {
	private int mId;
	private int mConversationId;
	private User mUser;

	public User getUser() {
		return mUser;
	}

	public void setUser(User user) {
		this.mUser = user;
	}

	public int getId() {
		return mId;
	}

	public void setId(int mId) {
		this.mId = mId;
	}

	public int getConversationId() {
		return mConversationId;
	}

	public void setConversationId(int mConversationId) {
		this.mConversationId = mConversationId;
	}

}
