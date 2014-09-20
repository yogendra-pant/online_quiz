package cc.catalysts.catcoder.server.web.model;

public class PasswordRecovery {

	private String password;

	private String confirmPassword;

	private String ticket;

	public PasswordRecovery() {

	}

	public PasswordRecovery(String ticket) {
		this.ticket = ticket;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getTicket() {
		return ticket;
	}

}
