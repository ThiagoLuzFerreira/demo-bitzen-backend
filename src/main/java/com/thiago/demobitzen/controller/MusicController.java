package com.thiago.demobitzen.controller;

import com.thiago.demobitzen.dto.MusicDTO;
import com.thiago.demobitzen.model.Artist;
import com.thiago.demobitzen.model.Music;
import com.thiago.demobitzen.service.ArtistService;
import com.thiago.demobitzen.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    private MusicService service;

    @GetMapping("/{id}")
    ResponseEntity<Music> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    ResponseEntity<Page<Music>> findAll(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
            @RequestParam(value = "sort", defaultValue = "asc") String sort){

        var sortDirection = "desc".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, "id"));
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PostMapping
    ResponseEntity<Music> save(@RequestBody MusicDTO musicDTO){

        Music musicSaved = service.save(musicDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(musicDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(musicSaved);
    }
    
    @PutMapping
    ResponseEntity<Music> update(@RequestBody MusicDTO musicDTO){
        return ResponseEntity.ok().body(service.update(musicDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
