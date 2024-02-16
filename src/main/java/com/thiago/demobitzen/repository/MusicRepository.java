package com.thiago.demobitzen.repository;

import com.thiago.demobitzen.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {


}
