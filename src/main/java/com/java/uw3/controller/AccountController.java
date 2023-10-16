package com.java.uw3.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.uw3.dto.*;
import com.java.uw3.model.*;
import com.java.uw3.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public List<Account> readAccounts() {
		return accService.getAccounts();
	}
	
	@RequestMapping(value="/user/{accId}", method=RequestMethod.GET)
	public AccountDto getAccountById(@PathVariable(value = "accId") Long id) {
		return accService.getAccountById(id);
	}
	
	@RequestMapping(value="/user/{accId}", method=RequestMethod.PUT)
	public Account updateAccounts(@PathVariable(value = "accId") Long id, @RequestBody Account accDetails) {
		return accService.updateAccount(id, accDetails);
	}
	
	@RequestMapping(value="/user/{accId}", method=RequestMethod.DELETE)
	public void deleteAccounts(@PathVariable(value = "accId") Long id) {
		accService.deleteAccount(id);
	}
	
	@RequestMapping(value="/user/{accId}/favSongs", method=RequestMethod.GET)
	public List<Song> getLikedSongs(@PathVariable(value = "accId") Long accId) {
		return accService.getLikedSongs(accId);
	}

	@RequestMapping(value="/user/{accId}/favAlbums", method=RequestMethod.GET)
	public List<Album> getLikedAlbums(@PathVariable(value = "accId") Long accId) {
		return accService.getLikedAlbums(accId);
	}

	@RequestMapping(value="/user/{accId}/likeSong/{songId}", method=RequestMethod.PUT)
	public Account likesSong(@PathVariable(value = "accId") Long accId, @PathVariable(value = "songId") Long songId) {
		return accService.likesSong(accId, songId);
	}

	@RequestMapping(value="/user/{accId}/unlikeSong/{songId}", method=RequestMethod.PUT)
	public Account unlikesSong(@PathVariable(value = "accId") Long accId, @PathVariable(value = "songId") Long songId){
        return accService.unlikesSong(accId, songId);
    }

	@RequestMapping(value="/user/{accId}/likeAlbum/{albumId}", method=RequestMethod.PUT)
	public Account likesAlbum(@PathVariable(value = "accId") Long accId, @PathVariable(value = "albumId") Long albumId) {
		return accService.likesAlbum(accId, albumId);
	}

	@RequestMapping(value="/user/{accId}/unlikeAlbum/{albumId}", method=RequestMethod.PUT)
	public Account unlikesAlbum(@PathVariable(value = "accId") Long accId, @PathVariable(value = "albumId") Long albumId) {
		return accService.unlikesAlbum(accId, albumId);
	}
	
	@RequestMapping(value="/user/{accId}/follow/{artistId}", method=RequestMethod.PUT)
	public Account follows(@PathVariable(value="accId") Long accId, @PathVariable(value="artistId") Long artistId){
        return accService.follows(accId, artistId);
    }

	@RequestMapping(value="/user/{accId}/unfollow/{artistId}", method=RequestMethod.PUT)
	public Account unfollows(@PathVariable(value="accId") Long accId, @PathVariable(value="artistId") Long artistId){
        return accService.unfollows(accId, artistId);
    }

	@RequestMapping(value="/user/{accId}/islikedsong/{songId}", method=RequestMethod.GET)
	public Boolean isLikedSong(@PathVariable(value="accId") Long accId, @PathVariable(value="songId") Long songId){
        return accService.isLikedSong(accId, songId);
    }
	
	@RequestMapping(value="/user/{accId}/islikedalbum/{albumId}", method=RequestMethod.GET)
	public Boolean isLikedAlbum(@PathVariable(value="accId") Long accId, @PathVariable(value="albumId") Long albumId){
        return accService.isLikedAlbum(accId, albumId);
    }
	
	@RequestMapping(value="/user/{accId}/isfollow/{artistId}", method=RequestMethod.GET)
	public Boolean isFollow(@PathVariable(value="accId") Long accId, @PathVariable(value="artistId") Long artistId){
        return accService.isFollow(accId, artistId);
    }
}
