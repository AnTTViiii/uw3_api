package com.java.uw3.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.java.uw3.model.*;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findArtistByUsername(String artistname);
	List<Account> findArtistByUsernameContains(String keyword);
	
}