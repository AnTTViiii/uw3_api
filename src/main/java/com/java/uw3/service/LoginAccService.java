package com.java.uw3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.uw3.model.*;
import com.java.uw3.repository.*;

@Service
public class LoginAccService {
	@Autowired
		LoginAccRepository loginRepo;
	// CREATE
	public LoginAccount createLoginAcc(LoginAccount loginAcc) {
		loginAcc.getAcc().setLoginAcc(loginAcc);
		return loginRepo.save(loginAcc);
	}

	// READ
	public List<LoginAccount> getLoginAccs() {
	    return loginRepo.findAll();
	}

	// DELETE
	public void deleteEmployee(Long loginId) {
	    loginRepo.deleteById(loginId);
	}

	// UPDATE
	public LoginAccount updateEmployee(Long loginId, LoginAccount loginDetails) {
		LoginAccount loginAcc = loginRepo.findById(loginId).get();
		loginAcc.setEmail(loginDetails.getEmail());
		loginAcc.setPassword(loginDetails.getPassword());

	    return loginRepo.save(loginAcc);
	}
	
	//LOGIN
	public LoginAccount login(LoginForm login) {
        LoginAccount account = loginRepo.findUserByEmail(login.getEmai());
        if(account!= null){
            if(account.getPassword().equals(login.getPassword()))
                return account;
        }
        return null;
	}
}
