package com.quiz.service;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RecoveryModel {

	private String keyCode;

	@NotEmpty
	@Email
	private String email;

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
