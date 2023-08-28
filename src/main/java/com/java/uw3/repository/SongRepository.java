package com.java.uw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uw3.model.Song;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
	Song findSongBySongname(String songName);
	List<Song> findSongBySongnameContains(String keyword);
}
