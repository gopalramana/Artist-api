package com.brain.software.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brain.software.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {




}