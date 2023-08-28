package com.java.uw3.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "loginaccount")
public class LoginAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
        private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "loginAcc")
    @JsonManagedReference
    Account acc;
    
    public LoginAccount() {}
    
    public LoginAccount(String email, String password) {
    	this.email = email;
    	this.password = password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
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

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}
}
