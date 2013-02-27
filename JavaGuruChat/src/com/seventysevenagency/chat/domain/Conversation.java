package com.seventysevenagency.chat.domain;

import com.seventysevenagency.chat.types.ConversationType.Type;

public class Conversation {	
	private Long id;
	private Type type;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long mId) {
		this.id = mId;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type mType) {
		this.type = mType;
	}
	public String getName() {
		return name;
	}
	public void setName(String mName) {
		this.name = mName;
	}
	
}
