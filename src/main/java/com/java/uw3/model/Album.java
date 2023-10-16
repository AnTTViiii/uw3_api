package com.java.uw3.model;

import java.util.*;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "albumname")
	private String albumname;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "releasedate")
	private Date releaseDate = new Date();
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "originalposterid")
	private Long opid;
	
	@JsonIgnore
    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();
	
	public  Album(){}

    public Album(String albumName, String image, String country, Date releaseDate, int likes) {
        this.albumname = albumName;
        this.img = image;
        this.country = country;
        this.releaseDate = releaseDate;
        this.likes = likes;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getOpId() {
		return opid;
	}

	public void setOpId(Long opId) {
		this.opid = opId;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
