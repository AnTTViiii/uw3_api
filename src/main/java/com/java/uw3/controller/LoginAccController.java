package com.java.uw3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.uw3.model.*;
import com.java.uw3.service.LoginAccService;

@RestController
@RequestMapping("/api")
public class LoginAccController {
	@Autowired
    	LoginAccService loginService;

	@RequestMapping(value="/acc", method=RequestMethod.POST)
	public LoginAccount createLoginAcc(@RequestBody LoginAccount loginAcc) {
	    return loginService.createLoginAcc(loginAcc);
	}

	@RequestMapping(value="/acc", method=RequestMethod.GET)
	public List<LoginAccount> readLoginAccs() {
	    return loginService.getLoginAccs();
	}

	@RequestMapping(value="/acc/{accId}", method=RequestMethod.PUT)
	public LoginAccount updateLoginAcc(@PathVariable(value = "accId") Long id, @RequestBody LoginAccount loginDetails) {
	    return loginService.updateEmployee(id, loginDetails);
	}

	@RequestMapping(value="/acc/{accId}", method=RequestMethod.DELETE)
	public void deleteLoginAcc(@PathVariable(value = "accId") Long id) {
		loginService.deleteEmployee(id);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public LoginAccount login(@RequestBody LoginForm login ) {
        return loginService.login(login);
    }
}
