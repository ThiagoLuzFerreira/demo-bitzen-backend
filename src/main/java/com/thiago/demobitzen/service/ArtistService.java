package com.thiago.demobitzen.service;

import com.thiago.demobitzen.dto.ArtistDTO;
import com.thiago.demobitzen.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ArtistService {

    Artist findById(Integer id);

    Page<Artist> findAll(Pageable pageable);

    Artist save(ArtistDTO artistDTO);

    Artist update(ArtistDTO artistDTO);

    void delete(Integer id);
}
