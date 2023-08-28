package com.java.uw3.dto;

import java.util.*;

public class AlbumDto {
	public Long id;
    public String albumname;
    public int likes;
    public Date releaseDate;
    public String albumimg;
    public Long poster;
    public String owner;
    public String country;
    
    public AlbumDto() {}

    public AlbumDto(Long id, String albumname, int likes, Date releaseDate, String image, Long poster, String owner, String country) {
        this.id = id;
        this.albumname = albumname;
        this.likes = likes;
        this.releaseDate = releaseDate;
        this.albumimg = image;
        this.poster = poster;
        this.owner = owner;
        this.country = country;
    }
}
