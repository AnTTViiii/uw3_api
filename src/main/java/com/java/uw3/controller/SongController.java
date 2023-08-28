package com.java.uw3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.uw3.model.*;
import com.java.uw3.service.SongService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class SongController {
	@Autowired
	SongService songService;
	
	@RequestMapping(value="/song", method=RequestMethod.POST)
	public Song uploadSong(@RequestBody Song song) {
    	return songService.uploadSong(song);
    }
    
	@RequestMapping(value="/song", method=RequestMethod.GET)
    public List<Song> getSongs(){
        return songService.getSongs();
    }
    
	@RequestMapping(value="/featuredSong", method=RequestMethod.GET)
    public List<Song> getFeaturedSongs(){
        return songService.getFeaturedSongs();
    }
    
	@RequestMapping(value="/latestSong", method=RequestMethod.GET)
	public List<Song> getLatestSongs(){
        return songService.getLatestSongs();
    }
	
	@RequestMapping(value="/song/{songId}", method=RequestMethod.GET)
	public Song getSongById(@PathVariable(value="songId") Long songId){
        return songService.getSongById(songId);
    }
    
    @RequestMapping(value="/song/{songId}", method=RequestMethod.PUT)
	public Song updateSong(@PathVariable(value="songId") Long songId, @RequestBody Song song) {
    	return songService.updateSong(songId, song);
    }
    
    @RequestMapping(value="/song/{songId}/stream", method=RequestMethod.PUT)
	public Song songStreams(@PathVariable(value="songId") Long songId) {
    	return songService.songStreams(songId);
    }
    
    @RequestMapping(value="/song/{songId}", method=RequestMethod.DELETE)
    public void deleteSong(@PathVariable(value="songId") Long songId) {
    	songService.deleteSong(songId);
    }
}
