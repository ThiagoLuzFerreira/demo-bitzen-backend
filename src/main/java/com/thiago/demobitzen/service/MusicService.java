package com.thiago.demobitzen.service;

import com.thiago.demobitzen.dto.MusicDTO;
import com.thiago.demobitzen.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MusicService {

    Music findById(Integer id);

    Page<Music> findAll(Pageable pageable);

    Music save(MusicDTO musicDTO);

    Music update(MusicDTO musicDTO);

    void delete(Integer id);

    List<Music> getAllSongsByArtist(Integer artistId);
}
