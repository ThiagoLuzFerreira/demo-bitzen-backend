package com.thiago.demobitzen.dto;

import com.thiago.demobitzen.model.Album;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class AlbumDTO implements Serializable {

    private Integer id;
    @NotBlank(message = "preenchimento do campo titulo e obrigatorio")
    private String title;

    @NotBlank(message = "preenchimento do campo ano e obrigatorio")
    private String year;

    @NotBlank(message = "preenchimento do campo imagem e obrigatorio")
    private String image;

    @NotBlank(message = "preenchimento do campo artista e obrigatorio")
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
