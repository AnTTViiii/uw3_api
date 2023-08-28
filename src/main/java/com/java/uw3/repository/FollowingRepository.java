package com.java.uw3.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uw3.model.Following;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {
	Following findByFolloweridAndArtistid(Long userid, Long artistid);
	Set<Following> findByFollowerid(Long userid);
}
