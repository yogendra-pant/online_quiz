package com.quiz.entities;

import com.quiz.annotations.DontSerialize;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractUser extends Principal {
	private static final long serialVersionUID = 1L;

	private boolean disabled;
	private String password;
	private String authority;
	private Date lastLogin;
	private Date lastLoginAttempt;
	private int failedLoginCounter;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Basic(optional = false)
	public int getFailedLoginCounter() {
		return failedLoginCounter;
	}

	public void setFailedLoginCounter(int failedLoginCounter) {
		this.failedLoginCounter = failedLoginCounter;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastLoginAttempt() {
		return lastLoginAttempt;
	}

	public void setLastLoginAttempt(Date lastLoginAttempt) {
		this.lastLoginAttempt = lastLoginAttempt;
	}

	@DontSerialize
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
