package com.thiago.demobitzen.dto;

import com.thiago.demobitzen.model.Album;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public class AlbumDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "titulo nao deve estar vazio")
    private String title;
    @NotEmpty(message = "ano nao deve estar vazio")
    private String year;
    @NotEmpty(message = "imagem nao deve estar vazio")
    private String image;
    private Integer artist;

    public AlbumDTO() {
    }

    public AlbumDTO(Album album) {
        this.id = album.getId();
        this.title = album.getTitle();
        this.year = album.getYear();
        this.image = album.getImage();
        this.artist = album.getArtist().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getArtist() {
        return artist;
    }

    public void setArtist(Integer artist) {
        this.artist = artist;
    }
}
