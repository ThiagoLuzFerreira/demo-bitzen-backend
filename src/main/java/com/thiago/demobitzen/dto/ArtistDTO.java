package com.thiago.demobitzen.dto;

import com.thiago.demobitzen.model.Artist;

import java.io.Serializable;

public class ArtistDTO implements Serializable {

    private Integer id;
    private String name;
    private String image;

    public ArtistDTO() {
    }

    public ArtistDTO(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public ArtistDTO(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.image = artist.getImage();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
