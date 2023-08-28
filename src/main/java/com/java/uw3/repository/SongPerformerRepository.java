package com.java.uw3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.uw3.model.SongPerformer;

@Repository
public interface SongPerformerRepository extends JpaRepository<SongPerformer, Long> {
	List<SongPerformer> findBySongid(Long songid);
	List<SongPerformer> findByArtistid(Long artistid);
}
