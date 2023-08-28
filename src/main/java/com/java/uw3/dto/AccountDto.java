package com.java.uw3.dto;

import java.util.*;

import com.java.uw3.model.Account;

public class AccountDto {
	public String username;
	public String avatar;
	public String ethwallet;
	public int followercount;
	public Set<Account> favArtists = new HashSet<>();
	
	public AccountDto() {}
	public AccountDto(String username, String avatar, String ethwallet, int follower, Set<Account> favArtists) {
		this.username = username;
		this.avatar = avatar;
		this.ethwallet = ethwallet;
		this.followercount = follower;
		this.favArtists = favArtists;
	}
}
