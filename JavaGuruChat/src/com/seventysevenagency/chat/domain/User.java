package com.seventysevenagency.chat.domain;

import java.util.Set;

public class User {
	private int mId;
	private String mName;
	private String mSurname;
	private String mUsername;
	private String mPassword;
	private String mEmail;
	private Set<Message> mMessages;
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmSurname() {
		return mSurname;
	}
	public void setmSurname(String mSurname) {
		this.mSurname = mSurname;
	}
	public String getmUsername() {
		return mUsername;
	}
	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public Set<Message> getmMessages() {
		return mMessages;
	}
	public void setmMessages(Set<Message> mMessages) {
		this.mMessages = mMessages;
	}

}
