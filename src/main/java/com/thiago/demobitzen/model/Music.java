package com.thiago.demobitzen.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Music implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 250)
    private String title;
    @Column(length = 6)
    private String duration;
    private Integer track;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}
