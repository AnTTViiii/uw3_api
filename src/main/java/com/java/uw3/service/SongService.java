package com.java.uw3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.uw3.model.*;
import com.java.uw3.repository.*;
import java.util.*;

@Service
public class SongService {
	@Autowired
    private SongRepository songRepo;
    
    public Song uploadSong(Song song) {
    	Song request = song;
    	for (Account a:song.getPerformer()) {
    		request.addPerformer(a);
    	}
    	request.setPerformer(song.getPerformer());
    	return songRepo.save(request);
    }
    
    public List<Song> getSongs(){
        return songRepo.findAll();
    }
    
    public List<Song> getFeaturedSongs(){
        return songRepo.findAll(Sort.by("likes").descending());
    }
    
    public List<Song> getLatestSongs(){
        return songRepo.findAll(Sort.by("id").descending());
    }
    
    public Song getSongById(Long songid){
        return songRepo.findById(songid).get();
    }
    
    public List<Song> getSongByAlbumId(Long albumid) {
    	return songRepo.findByAlbumid(albumid);
    }
    
    public Song updateSong(Long songId, Song song) {
    	Song songTemp = songRepo.findById(songId).get();
    	songTemp.setSongname(song.getSongname());
    	songTemp.setImg(song.getImg());
    	songTemp.setLyrics(song.getLyrics());
    	songTemp.setDuration(song.getDuration());
        songTemp.setAudio(song.getAudio());
        songTemp.setGenre(song.getGenre());
        songTemp.setAlbumid(song.getAlbumid());
        for (Account a:song.getPerformer()) {
        	songTemp.addPerformer(a);
    	}
        songTemp.setPerformer(song.getPerformer());
        return songRepo.save(songTemp);
    }
    
    public Song songStreams(Long songId) {
    	Song song = songRepo.findById(songId).get();
    	song.setStreams(song.getStreams()+1);
    	return songRepo.save(song);
    }
    
    public void deleteSong(Long songId) {
    	songRepo.deleteById(songId);
    }
}
