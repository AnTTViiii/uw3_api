package com.java.uw3.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.uw3.model.*;
import com.java.uw3.repository.*;

@Service
public class ArtistService {
	@Autowired
    private AccountRepository accRepo;
	
	@Autowired
	private SongPerformerRepository songPerformerRepo;
  
	@Autowired
    private AlbumRepository albumRepo;
	
	@Autowired
    private SongRepository songRepo;
	
	//Read
	public List<Account> getArtists() {
		List<SongPerformer> performers = songPerformerRepo.findAll();
		List<Account> artists = new ArrayList<>();
		for(SongPerformer p:performers) {
			Account a = accRepo.findById(p.getArtistid()).get();
			if(!artists.contains(a)) {
				artists.add(a);
			}
		}
		return artists;
	}
	//Get Artist Song & Album
    public List<Song> getArtistOwnSongs(Long artistId) {
    	List<SongPerformer> performers = songPerformerRepo.findByArtistid(artistId);
    	List<Song> songs = new ArrayList<>();
    	for (SongPerformer p:performers) {
    		songs.add(songRepo.findById(p.getSongid()).get());
    	}
    	return songs;
    }
    
    public List<Album> getArtistOwnAlbums(Long artistId) {
    	List<Album> albums = albumRepo.findByOpid(artistId);
    	return albums;
    }
    //Get Artist Colab Albums
    public List<Album> getArtistColabAlbums(Long artistId) {
    	List<SongPerformer> performers = songPerformerRepo.findByArtistid(artistId);
    	List<Album> albums = new ArrayList<>();
    	for(SongPerformer p:performers) {
    		albums.add(albumRepo.findById(songRepo.findById(p.getSongid()).get().getAlbumid()).get());
    	}
    	List<Album> result = new ArrayList<>();
    	for (Album a:albums) {
    		if (a.getOpId() != artistId) {
    			result.add(a);
    		}
    	}
    	return result;
    }
}
