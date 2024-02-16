package com.thiago.demobitzen.service.impl;

import com.thiago.demobitzen.dto.MusicDTO;
import com.thiago.demobitzen.exceptions.ResourceNotFoundException;
import com.thiago.demobitzen.model.Album;
import com.thiago.demobitzen.model.Music;
import com.thiago.demobitzen.repository.AlbumRepository;
import com.thiago.demobitzen.repository.MusicRepository;
import com.thiago.demobitzen.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository repository;

    @Autowired
    private AlbumRepository albumRepository;


    @Override
    public Music findById(Integer id) {
        log.info("Finding music by ID " + id);
        Music music = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Music not found"));
        return music;
    }

    @Override
    public Page<Music> findAll(Pageable pageable) {
        log.info("Finding all musics");
        Page<Music> musics = repository.findAll(pageable);
        return musics;
    }

    @Transactional
    @Override
    public Music save(MusicDTO musicDTO) {
        log.info("Saving music");
        Album album = albumRepository.findById(musicDTO.getAlbum()).orElseThrow(() -> new ResourceNotFoundException("Album not found"));
        Music music = new Music();
        music.setTitle(musicDTO.getTitle());
        music.setDuration(musicDTO.getDuration());
        music.setTrack(musicDTO.getTrack());
        music.setAlbum(album);
        return repository.save(music);
    }

    @Transactional
    @Override
    public Music update(MusicDTO musicDTO) {
        log.info("Updating music ID " + musicDTO.getId());
        Album album = albumRepository.findById(musicDTO.getAlbum()).orElseThrow(() -> new ResourceNotFoundException("Album not found"));
        Music foundMusic = repository.findById(musicDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Music not found"));
        foundMusic.setTitle(musicDTO.getTitle());
        foundMusic.setDuration(musicDTO.getDuration());
        foundMusic.setTrack(musicDTO.getTrack());
        foundMusic.setAlbum(album);
        return repository.save(foundMusic);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        log.info("Deleting music by ID " + id);
        repository.deleteById(id);
    }
}
