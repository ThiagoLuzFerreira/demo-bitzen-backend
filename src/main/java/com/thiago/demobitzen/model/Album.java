package com.thiago.demobitzen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 250)
    private String title;
    @Column(length = 45)
    private String year;
    @Column(columnDefinition="text")
    private String image;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnore
    private Artist artist;
    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Music> musics = new ArrayList<>();
}
