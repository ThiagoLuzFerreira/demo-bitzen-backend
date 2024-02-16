package com.thiago.demobitzen.dto;

import com.thiago.demobitzen.model.Music;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class MusicDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "titulo nao deve estar vazio")
    private String title;
    @NotEmpty(message = "duracao nao deve estar vazio")
    private String duration;

    @Min(value = 1, message = "numero da faixa deve ser maior que 0")
    @NotNull(message = "faixa nao deve estar vazio")
    private Integer track;
    @NotNull(message = "album nao deve estar vazio")
    private Integer album;

    public MusicDTO() {
    }

    public MusicDTO(Music music) {
        this.id = music.getId();
        this.title = music.getTitle();
        this.duration = music.getDuration();
        this.track = music.getTrack();
        this.album = music.getAlbum().getId();
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Integer getAlbum() {
        return album;
    }

    public void setAlbum(Integer album) {
        this.album = album;
    }
}
