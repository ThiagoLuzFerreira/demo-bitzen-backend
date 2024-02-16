package com.thiago.demobitzen.service.impl;

import com.thiago.demobitzen.dto.ArtistDTO;
import com.thiago.demobitzen.exceptions.ResourceNotFoundException;
import com.thiago.demobitzen.model.Artist;
import com.thiago.demobitzen.repository.ArtistRepository;
import com.thiago.demobitzen.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository repository;

    @Override
    public Artist findById(Integer id) {
        log.info("Finding artist by ID " + id);
        Artist artist = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        return artist;
    }

    @Override
    public Page<Artist> findAll(Pageable pageable) {
        log.info("Finding all artists");
        Page<Artist> artistsPage = repository.findAll(pageable);
        return artistsPage;
    }

    @Transactional
    @Override
    public Artist save(ArtistDTO artistDTO) {
        log.info("Saving artist");
        Artist artist = new Artist();
        artist.setName(artistDTO.getName());
        artist.setImage(artistDTO.getImage());
        return repository.save(artist);
    }

    @Transactional
    @Override
    public Artist update(ArtistDTO artistDTO) {
        log.info("Updating artist ID " + artistDTO.getId());
        Artist foundArtist = repository.findById(artistDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        foundArtist.setName(artistDTO.getName());
        foundArtist.setImage(artistDTO.getImage());
        return repository.save(foundArtist);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        log.info("Deleting artist by ID " + id);
        repository.deleteById(id);
    }
}
