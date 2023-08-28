package com.java.uw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uw3.model.*;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	Album findAlbumByAlbumname(String albumName);
	List<Album> findAlbumByAlbumnameContains(String keyword);
	List<Album> findByOpid(Long opId);
}
