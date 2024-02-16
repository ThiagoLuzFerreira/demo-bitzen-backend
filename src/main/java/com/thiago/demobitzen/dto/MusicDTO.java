package com.thiago.demobitzen.dto;

import com.thiago.demobitzen.model.Music;

import java.io.Serializable;

public class MusicDTO implements Serializable {

    private Integer id;
    private String title;
    private String duration;
    private Integer track;
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
