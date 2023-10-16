package com.java.uw3.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.uw3.model.Album;
import com.java.uw3.service.*;
import com.java.uw3.dto.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AlbumController {
	@Autowired
    private AlbumService albumService;
	
	@RequestMapping(value="/latestAlbum", method=RequestMethod.GET)
    public List<AlbumDto> getLatestAlbum() {
    	return albumService.getAlbums();
    }
    
	@RequestMapping(value="/album/{albumId}", method=RequestMethod.GET)
    public AlbumDto getAlbumById(@PathVariable(value="albumId") Long albumId) {
		return albumService.getAlbumById(albumId);
	}
    
	@RequestMapping(value="user/{userId}/album", method=RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album, @PathVariable(value="userId") Long userId) {
    	return albumService.createAlbum(album, userId);
    }
    
	@RequestMapping(value="album/{albumId}", method=RequestMethod.PUT)
    public Album updateAlbum(@PathVariable(value="albumId") Long albumId, @RequestBody Album albumDetails) {
    	return albumService.updateAlbum(albumId, albumDetails);
	}
    
	@RequestMapping(value="album/{albumId}", method=RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable(value="albumId") Long albumId) {
    	albumService.deleteAlbum(albumId);;
	}
	
	@RequestMapping(value="album/{albumId}/streams", method=RequestMethod.GET)
    public Long getAlbumStreams(@PathVariable(value="albumId") Long albumId) {
    	return albumService.getAlbumStreams(albumId);
	}
}
