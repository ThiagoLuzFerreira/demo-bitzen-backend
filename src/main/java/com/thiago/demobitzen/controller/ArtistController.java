package com.thiago.demobitzen.controller;

import com.thiago.demobitzen.dto.ArtistDTO;
import com.thiago.demobitzen.model.Artist;
import com.thiago.demobitzen.service.ArtistService;
import jakarta.validation.Valid;
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
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService service;

    @GetMapping("/{id}")
    ResponseEntity<Artist> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    ResponseEntity<Page<Artist>> findAll(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
            @RequestParam(value = "sort", defaultValue = "asc") String sort){

        var sortDirection = "desc".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, "name"));
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PostMapping
    ResponseEntity<Artist> save(@RequestBody @Valid ArtistDTO artistDTO){

        Artist artistSaved = service.save(artistDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(artistDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(artistSaved);
    }
    
    @PutMapping
    ResponseEntity<Artist> update(@RequestBody @Valid ArtistDTO artistDTO){
        return ResponseEntity.ok().body(service.update(artistDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
