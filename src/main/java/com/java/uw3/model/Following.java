package com.java.uw3.model;

import javax.persistence.*;

@Entity
@Table(name = "following")
public class Following {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "artistid")
	private Long artistid;
	
	@Column(name = "followerid")
	private Long followerid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArtistid() {
		return artistid;
	}

	public void setArtistid(Long artistid) {
		this.artistid = artistid;
	}

	public Long getFollowerid() {
		return followerid;
	}

	public void setFollowerid(Long followerid) {
		this.followerid = followerid;
	}

}
