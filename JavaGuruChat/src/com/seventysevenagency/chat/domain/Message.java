package com.seventysevenagency.chat.domain;

public class Message {
	private Long mId;
	private Long mUserId;
	private Long mConversationId;
	public Long getId() {
		return mId;
	}
	public void setId(Long mId) {
		this.mId = mId;
	}
	public Long getUserId() {
		return mUserId;
	}
	public void setUserId(Long mUserId) {
		this.mUserId = mUserId;
	}
	public Long getConversationId() {
		return mConversationId;
	}
	public void setConversationId(Long mConversationId) {
		this.mConversationId = mConversationId;
	}
	
}
