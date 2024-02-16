package com.thiago.demobitzen.repository;

import com.thiago.demobitzen.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {


}
