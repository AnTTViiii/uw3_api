package com.java.uw3.model;

import javax.persistence.*;

@Entity
@Table(name = "user_likedsong")
public class UserLikedSong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "userid")
	private Long userid;
	
	@Column(name = "songid")
	private Long songid;

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

	public Long getSongid() {
		return songid;
	}

	public void setSongid(Long songid) {
		this.songid = songid;
	}

}
