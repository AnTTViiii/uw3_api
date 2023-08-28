package com.java.uw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.uw3.model.UserLikedSong;

public interface UserLikedSongRepository extends JpaRepository<UserLikedSong, Long> {
	UserLikedSong findBySongidAndUserid(Long songid, Long userid);
}
