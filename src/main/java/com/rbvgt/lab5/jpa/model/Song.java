package com.rbvgt.lab5.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Song {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Song song;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
