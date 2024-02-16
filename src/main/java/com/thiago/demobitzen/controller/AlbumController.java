package com.thiago.demobitzen.controller;

import com.thiago.demobitzen.dto.AlbumDTO;
import com.thiago.demobitzen.model.Album;
import com.thiago.demobitzen.service.AlbumService;
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
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @GetMapping("/{id}")
    ResponseEntity<Album> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    ResponseEntity<Page<Album>> findAll(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
            @RequestParam(value = "sort", defaultValue = "asc") String sort){

        var sortDirection = "desc".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, "id"));
        return ResponseEntity.ok().body(service.findAll(pageable));
    }


    @PostMapping
    ResponseEntity<Album> save(@RequestBody @Valid AlbumDTO albumDTO){

        Album albumSaved = service.save(albumDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(albumDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(albumSaved);
    }
    
    @PutMapping
    ResponseEntity<Album> update(@RequestBody @Valid AlbumDTO albumDTO){
        return ResponseEntity.ok().body(service.update(albumDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
