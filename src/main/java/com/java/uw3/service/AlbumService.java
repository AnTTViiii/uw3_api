package com.java.uw3.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.uw3.model.*;
import com.java.uw3.repository.*;
import com.java.uw3.dto.*;

@Service
@Transactional 
public class AlbumService {
	@Autowired
    private AlbumRepository albumRepo;
	
	@Autowired
    private SongRepository songRepo;

    @Autowired
    private AccountRepository artistRepo;
    
    public List<AlbumDto> getAlbums() {
    	List<Album> albums = albumRepo.findAll();
        List<AlbumDto> result = new ArrayList<AlbumDto>();
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
    
    public AlbumDto getAlbumById(Long albumId) {
    	Album album = albumRepo.findById(albumId).get();
        AlbumDto result = new AlbumDto();
        result.id = album.getId();
        result.albumname = album.getAlbumname();
        result.albumimg = album.getImg();
        result.likes = album.getLikes();
        result.releaseDate = album.getReleaseDate();
        result.poster = album.getOpId();
        result.owner = artistRepo.findById(album.getOpId()).get().getUsername();
        result.country = album.getCountry();
        return result;
    }
    
//    public Optional<Album> getAlbumById(Long albumId) {
//		return albumRepo.findById(albumId);
//	}
    
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
    	songRepo.deleteByAlbumid(albumId);
		albumRepo.deleteById(albumId);
	}
    
    public Long getAlbumStreams(Long albumId) {
    	Long count = 0L;
    	List<Song> songs = songRepo.findByAlbumid(albumId);
    	for (Song s:songs) {
    		count += s.getStreams();
    	}
		return count;
	}
    
}
