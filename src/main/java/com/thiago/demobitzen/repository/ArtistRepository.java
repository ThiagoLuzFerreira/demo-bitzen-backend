package com.thiago.demobitzen.repository;

import com.thiago.demobitzen.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {


}
