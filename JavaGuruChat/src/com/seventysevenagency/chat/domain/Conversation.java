package com.seventysevenagency.chat.domain;

import com.seventysevenagency.chat.types.ConversationType.Type;

public class Conversation {	
	private Long mId;
	private Type mType;
	private String mName;
	public Long getId() {
		return mId;
	}
	public void setId(Long mId) {
		this.mId = mId;
	}
	public Type getType() {
		return mType;
	}
	public void setType(Type mType) {
		this.mType = mType;
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	
}
