package com.java.uw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.uw3.model.UserLikedAlbum;

public interface UserLikedAlbumRepository extends JpaRepository<UserLikedAlbum, Long> {
	UserLikedAlbum findByAlbumidAndUserid(Long albumid, Long userid);
}
