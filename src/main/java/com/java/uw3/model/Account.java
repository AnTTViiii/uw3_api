package com.java.uw3.model;

import javax.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "account")
public class Account {
	@Id
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="avatar")
	private String avatar = "https://res.cloudinary.com/dpwehcnso/image/upload/v1687426572/t420uv99c8anfzjw6okq.png";
	
	@Column(name="ethwallet", nullable = true)
	private String ethwallet;
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	@JsonBackReference
	private LoginAccount loginAcc;
	
	@Column(name="followercount", nullable = true)
	private int followercount = 0;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<Album> albums = new ArrayList<>();
	
	@JsonIgnore
    @ManyToMany
    @JoinTable(name="following",
            joinColumns = @JoinColumn(name="followerid"),
            inverseJoinColumns = @JoinColumn(name="artistid")
    )
    private List<Account> favArtists = new ArrayList<>();
	
	@JsonIgnore
    @ManyToMany
    @JoinTable(
            name="user_likedsong",
            joinColumns = @JoinColumn(name="userid"),
            inverseJoinColumns = @JoinColumn(name="songid")
    )
    private List<Song> likedSong = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="user_likedalbum",
            joinColumns = @JoinColumn(name="userid"),
            inverseJoinColumns = @JoinColumn(name="albumid")
    )
    private List<Album> likedAlbum = new ArrayList<>();
	
	public Account() {}
	
	public Account(String username, String avt, String ethwallet) {
		this.username = username;
		this.avatar = avt;
		this.ethwallet = ethwallet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEthwallet() {
		return ethwallet;
	}

	public void setEthwallet(String ethwallet) {
		this.ethwallet = ethwallet;
	}
	
	public LoginAccount getLoginAcc() {
		return loginAcc;
	}

	public void setLoginAcc(LoginAccount loginAcc) {
		this.loginAcc = loginAcc;
	}

	public List<Song> getLikedSong() {
		return likedSong;
	}

	public void setLikedSong(List<Song> likedSong) {
		this.likedSong = likedSong;
	}

	public List<Album> getLikedAlbum() {
		return likedAlbum;
	}

	public void setLikedAlbum(List<Album> likedAlbum) {
		this.likedAlbum = likedAlbum;
	}
	
	public void likesSong(Song song){
        likedSong.add(song);
    }
	
    public void unlikesSong(Song song){
        likedSong.remove(song);
    }
    
    public void likesAlbum(Album album){
        likedAlbum.add(album);
    }
    
    public void unlikesAlbum(Album album){
    	likedAlbum.remove(album);
    }
    
    public void follows(Account artist){
    	favArtists.add(artist);
    }
    
    public void unfollows(Account artist){
    	favArtists.remove(artist);
    }

	public int getFollowercount() {
		return followercount;
	}

	public void setFollowercount(int followercount) {
		this.followercount = followercount;
	}
}
