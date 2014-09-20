package com.quiz.shared.entities;



public class Credentials{

	private String userName;
	private boolean admin;

	public Credentials() {
	}

	public Credentials(String userName, boolean admin) {
		this.userName = userName;
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
