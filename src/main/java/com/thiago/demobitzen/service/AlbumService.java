package com.thiago.demobitzen.service;

import com.thiago.demobitzen.dto.AlbumDTO;
import com.thiago.demobitzen.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumService {

    Album findById(Integer id);

    Page<Album> findAll(Pageable pageable);

    Album save(AlbumDTO albumDTO);

    Album update(AlbumDTO albumDTO);

    void delete(Integer id);
}
