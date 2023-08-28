package com.java.uw3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "song")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "songname")
	private String songname;
	
	@Column(name = "albumid")
	private Long albumid;
	
	@ManyToOne
    @JoinColumn(name = "albumid", insertable = false, updatable = false)
    private Album album;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "lyrics")
	private String lyrics;
	
	@Column(name = "audio")
	private String audio;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "duration")
	private float duration;
	
	@Column(name = "likes")
	private Long likes = 0L;
	
	@Column(name = "streams")
	private Long streams = 0L;
	
	@ManyToMany
    @JoinTable(name="song_performer",
            joinColumns = @JoinColumn(name="songid"),
            inverseJoinColumns = @JoinColumn(name="artistid")
    )
    private Set<Account> performer = new HashSet<>();
	
	public  Song(){}

    public Song(String songName, Long albumId, String genre, String lyrics, String audio, String image, float duration, Long likes, Long streams) {
        this.songname = songName;
        this.albumid = albumId;
        this.genre = genre;
        this.lyrics = lyrics;
        this.audio = audio;
        this.img = image;
        this.duration = duration;
        this.likes = likes;
        this.streams = streams;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Long getStreams() {
		return streams;
	}

	public void setStreams(Long streams) {
		this.streams = streams;
	}

	public Set<Account> getPerformer() {
		return performer;
	}

	public void setPerformer(Set<Account> performer) {
		this.performer = performer;
	}
	
	public void addPerformer(Account a) {
		this.performer.add(a);
	}
}
