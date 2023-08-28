package com.java.uw3.model;

import javax.persistence.*;

@Entity
@Table(name = "song_collector")
public class SongCollector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "songid")
	private Long songid;
	
	@Column(name = "collecterid")
	private Long collecterid;
	
	@Column(name = "price")
	private float price;

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

	public Long getCollecterid() {
		return collecterid;
	}

	public void setCollecterid(Long collecterid) {
		this.collecterid = collecterid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
