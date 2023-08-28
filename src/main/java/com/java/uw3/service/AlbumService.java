package com.java.uw3.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.uw3.model.*;
import com.java.uw3.repository.*;
import com.java.uw3.dto.*;

@Service
public class AlbumService {
	@Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private AccountRepository artistRepo;
    
    public Set<AlbumDto> getAlbums() {
    	List<Album> albums = albumRepo.findAll();
        Set<AlbumDto> result = new HashSet<AlbumDto>();
        for (Album a: albums) {
            AlbumDto album = new AlbumDto();
            album.id = a.getId();
            album.albumname = a.getAlbumname();
            album.albumimg = a.getImg();
            album.likes = a.getLikes();
            album.releaseDate = a.getReleaseDate();
            album.poster = a.getOpId();
            album.owner = artistRepo.findById(a.getOpId()).get().getUsername();
            album.country = a.getCountry();
            result.add(album);
        }
        return result;
    }
    
    public Optional<Album> getAlbumById(Long albumId) {
		return albumRepo.findById(albumId);
	}
    
    public Album createAlbum(Album album, Long userId) {
    	album.setOpId(userId);
    	return albumRepo.save(album);
    }
    
    public Album updateAlbum(Long albumId, Album albumDetails) {
    	Album album = albumRepo.findById(albumId).get();
    	album.setAlbumname(albumDetails.getAlbumname());
    	album.setCountry(albumDetails.getCountry());
    	album.setImg(albumDetails.getImg());
    	album.setReleaseDate(albumDetails.getReleaseDate());
		
		return albumRepo.save(album);
	}
    
    public void deleteAlbum(Long albumId) {
		albumRepo.deleteById(albumId);
	}
}
