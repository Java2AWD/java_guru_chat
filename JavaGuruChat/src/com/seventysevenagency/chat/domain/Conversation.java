package com.seventysevenagency.chat.domain;

import com.seventysevenagency.chat.types.ConversationType.Type;

public class Conversation {	
	private Integer mId;
	private Type mType;
	private String mName;
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public Type getmType() {
		return mType;
	}
	public void setmType(Type mType) {
		this.mType = mType;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
}
