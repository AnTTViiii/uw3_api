package com.java.uw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.uw3.model.LoginAccount;

@Repository
public interface LoginAccRepository extends JpaRepository<LoginAccount, Long> {
	LoginAccount findUserByEmail(String email);
}
