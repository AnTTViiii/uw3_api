package com.java.uw3.model;

public class LoginForm {
	private String email;
    private String password;
    
    public LoginForm() {}

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

	public String getEmai() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
