package com.java.uw3.model;

import javax.persistence.*;

@Entity
@Table(name = "user_likedalbum")
public class UserLikedAlbum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "userid")
	private Long userid;
	
	@Column(name = "albumid")
	private Long albumid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}

}
