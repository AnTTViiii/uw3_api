package com.java.uw3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.uw3.model.*;
import com.java.uw3.repository.*;
import com.java.uw3.dto.*;

import java.util.*;

@Service
public class AccountService {
	@Autowired
		AccountRepository accRepo;
	
	@Autowired
		SongRepository songRepo;
	
	@Autowired
		AlbumRepository albumRepo;
	
	@Autowired
		FollowingRepository followRepo;
	
	@Autowired
		UserLikedAlbumRepository userLikeAlbumRepo;
	
	@Autowired
		UserLikedSongRepository userLikeSongRepo;
	
	//Read
	public List<Account> getAccounts() {
		return accRepo.findAll();
	}
	
	public AccountDto getAccountById(Long accId) {
		AccountDto acc = new AccountDto();
		Account user = accRepo.findById(accId).get();
		acc.username = user.getUsername();
		acc.avatar = user.getAvatar();
		acc.ethwallet = user.getEthwallet();
		acc.followercount = user.getFollowercount();
        List<Following> userFavArtists = followRepo.findByFollowerid(accId);
        for (Following artist: userFavArtists) {
            acc.favArtists.add(accRepo.findById(artist.getArtistid()).get());
        }
		return acc;
	}
	
	//Delete
	public void deleteAccount(Long accId) {
		accRepo.deleteById(accId);
	}
	
	//Update
	public Account updateAccount(Long accId, Account accDetails) {
		Account acc = accRepo.findById(accId).get();
		acc.setUsername(accDetails.getUsername());
		acc.setAvatar(accDetails.getAvatar());
		acc.setEthwallet(accDetails.getEthwallet());
		
		return accRepo.save(acc);
	}
	
	//Get liked songs
	public List<Song> getLikedSongs(Long accId) {
		Optional<Account> user = accRepo.findById(accId);
		List<Song> songs = new ArrayList<Song>();
		if(user.isPresent()) {
			songs = user.get().getLikedSong().stream().toList();
		}
		return songs;
	}
	//Get liked albums
	public List<Album> getLikedAlbums(Long accId) {
		Optional<Account> user = accRepo.findById(accId);
		List<Album> albums = new ArrayList<Album>();
		if(user.isPresent()) {
			albums = user.get().getLikedAlbum().stream().toList();
		}
		return albums;
	}
	//Likes song
	public Account likesSong(Long accId, Long songId) {
		Account user = accRepo.findById(accId).get();
		Song song = songRepo.findById(songId).get();
		user.likesSong(song);
		Boolean rep = userLikeSongRepo.findBySongidAndUserid(songId, accId) != null ? true : false;
		if(rep == false) {
			song.setLikes(song.getLikes()+1);
			songRepo.save(song);
		}
		return accRepo.save(user);
	}
	//Unlikes song
	public Account unlikesSong(Long accId, Long songId){
        Account user = accRepo.findById(accId).get();
        Song song = songRepo.findById(songId).get();
        user.unlikesSong(song);
        Boolean rep = userLikeSongRepo.findBySongidAndUserid(songId, accId) != null ? true : false;
        if(rep) {
		    song.setLikes(song.getLikes() - 1);
		    songRepo.save(song);
        }
        return accRepo.save(user);
    }
	//Likes album
	public Account likesAlbum(Long accId, Long albumId) {
		Account user = accRepo.findById(accId).get();
		Album album = albumRepo.findById(albumId).get();
		Boolean rep = userLikeAlbumRepo.findByAlbumidAndUserid(albumId, accId) != null ? true : false;
		user.likesAlbum(album);
		if (rep == false) {
			album.setLikes(album.getLikes()+1);
			albumRepo.save(album);
		}
		return accRepo.save(user);
	}
	
	//Unlikes album
	public Account unlikesAlbum(Long accId, Long albumId){
    	Account user = accRepo.findById(accId).get();
		Album album = albumRepo.findById(albumId).get();
		Boolean rep = userLikeAlbumRepo.findByAlbumidAndUserid(albumId, accId) != null ? true : false;
		user.unlikesAlbum(album);
		if (rep) {
			album.setLikes(album.getLikes()-1);
			albumRepo.save(album);
		}
		return accRepo.save(user);
    }
	//follow
	public Account follows(Long accId, Long artistId){
        Account user = accRepo.findById(accId).get();
        Account artist = accRepo.findById(artistId).get();
        Boolean rep =  followRepo.findByFolloweridAndArtistid(accId, artistId) != null ? true : false;
     
        if (rep != true) {
        	user.follows(artist);
        	accRepo.save(user);
        	artist.setFollowercount(artist.getFollowercount() + 1);
        }
        return accRepo.save(artist);
    }
	//unfollows
	public Account unfollows(Long accId, Long artistId){
    	Account user = accRepo.findById(accId).get();
    	Account artist = accRepo.findById(artistId).get();
    	Boolean rep =  followRepo.findByFolloweridAndArtistid(accId, artistId) != null ? true : false;
        
        if (rep == true) {
        	user.unfollows(artist);
            accRepo.save(user);
            artist.setFollowercount(artist.getFollowercount() - 1);
        }
        return accRepo.save(artist);
    }
	//---------------------------
	public Boolean isLikedSong(Long accId, Long songId){
        return userLikeSongRepo.findBySongidAndUserid(songId, accId) != null;
    }
	public Boolean isLikedAlbum(Long accId, Long albumId){
        return userLikeAlbumRepo.findByAlbumidAndUserid(albumId, accId) != null;
    }
	public Boolean isFollow(Long accId, Long artistId){
        return followRepo.findByFolloweridAndArtistid(accId, artistId) != null;
    }
}
