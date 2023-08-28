package com.java.uw3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.uw3.model.Account;
import com.java.uw3.model.Album;
import com.java.uw3.model.Song;
import com.java.uw3.service.*;

@RestController
@RequestMapping("/api")
public class ArtistController {
	@Autowired
    private ArtistService artistService;
	
	@RequestMapping(value="/artist", method=RequestMethod.GET)
	public List<Account> getArtists() {
		return artistService.getArtists();
	}
	
	@RequestMapping(value="/artist/{artistId}/song", method=RequestMethod.GET)
    public List<Song> getArtistOwnSongs(@PathVariable(value="artistId") Long artistId) {
    	return artistService.getArtistOwnSongs(artistId);
    }
    
	@RequestMapping(value="/artist/{artistId}/album", method=RequestMethod.GET)
    public List<Album> getArtistOwnAlbums(@PathVariable(value="artistId") Long artistId) {
    	return artistService.getArtistOwnAlbums(artistId);
    }

	@RequestMapping(value="/artist/{artistId}/colabAlbum", method=RequestMethod.GET)
    public List<Album> getArtistColabAlbums(@PathVariable(value="artistId") Long artistId) {
    	return artistService.getArtistColabAlbums(artistId);
    }

}
