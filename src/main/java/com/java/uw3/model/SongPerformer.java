package com.java.uw3.model;

import javax.persistence.*;

@Entity
@Table(name = "song_performer")
public class SongPerformer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "songid")
	private Long songid;
	
	@Column(name = "artistid")
	private Long artistid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSongid() {
		return songid;
	}

	public void setSongid(Long songid) {
		this.songid = songid;
	}

	public Long getArtistid() {
		return artistid;
	}

	public void setArtistid(Long artistid) {
		this.artistid = artistid;
	}
}
