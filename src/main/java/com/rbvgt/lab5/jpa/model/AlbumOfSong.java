package com.rbvgt.lab5.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AlbumOfSong {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "quantity", length = 30)
    private Integer quantity;
    @Basic
    @Column(name = "name", length = 25)
    private String name;
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private AlbumOfSong albumOfSong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        AlbumOfSong albumOfSong = (AlbumOfSong) o;
        return Objects.equals(id, albumOfSong.id) && Objects.equals(quantity, albumOfSong.quantity) && Objects.equals(name, albumOfSong.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, name);
    }

    public AlbumOfSong getAlbumOfSong() {
        return albumOfSong;
    }

    public void setAlbumOfSong(AlbumOfSong albumOfSong) {
        this.albumOfSong = albumOfSong;
    }
}
