package com.seventysevenagency.chat.domain;

public class User {
	private int mId;
	private String mName;
	private String mSurname;
	private String mUsername;
	private String mPassword;
	private String mEmail;

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		this.mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public String getSurname() {
		return mSurname;
	}

	public void setSurname(String surname) {
		this.mSurname = surname;
	}

	public String getUsername() {
		return mUsername;
	}

	public void setUsername(String username) {
		this.mUsername = username;
	}

	public String getPassword() {
		return mPassword;
	}

	public void setPassword(String password) {
		this.mPassword = password;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String email) {
		this.mEmail = email;
	}
}
