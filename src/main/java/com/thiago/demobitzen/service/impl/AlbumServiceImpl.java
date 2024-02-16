package com.thiago.demobitzen.service.impl;

import com.thiago.demobitzen.dto.AlbumDTO;
import com.thiago.demobitzen.exceptions.ResourceNotFoundException;
import com.thiago.demobitzen.model.Album;
import com.thiago.demobitzen.model.Artist;
import com.thiago.demobitzen.repository.AlbumRepository;
import com.thiago.demobitzen.repository.ArtistRepository;
import com.thiago.demobitzen.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Album findById(Integer id) {
        log.info("Finding album by ID " + id);
        Album album = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album not found"));
        return album;
    }

    @Override
    public Page<Album> findAll(Pageable pageable) {
        log.info("Finding all albums");
        Page<Album> albums = repository.findAll(pageable);
        return albums;
    }

    @Transactional
    @Override
    public Album save(AlbumDTO albumDTO) {
        log.info("Saving album");
        Artist artist = artistRepository.findById(albumDTO.getArtist()).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        Album album = new Album();
        album.setTitle(albumDTO.getTitle());
        album.setYear(albumDTO.getYear());
        album.setImage(albumDTO.getImage());
        album.setArtist(artist);
        return repository.save(album);
    }

    @Transactional
    @Override
    public Album update(AlbumDTO albumDTO) {
        log.info("Updating album ID " + albumDTO.getId());
        Artist artist = artistRepository.findById(albumDTO.getArtist()).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        Album foundAlbum = repository.findById(albumDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Album not found"));
        foundAlbum.setTitle(albumDTO.getTitle());
        foundAlbum.setYear(albumDTO.getYear());
        foundAlbum.setImage(albumDTO.getImage());
        foundAlbum.setArtist(artist);
        return foundAlbum;
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        log.info("Deleting album by ID " + id);
        repository.deleteById(id);
    }
}
