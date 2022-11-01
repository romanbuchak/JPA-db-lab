package com.rbvgt.lab5.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MusicalLables {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name", length = 25)
    private String name;
    @Basic
    @Column(name = "isAvard", length = 30)
    private String isAvard;
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private MusicalLables musicalLables;

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

    public String getIsAvard() {
        return isAvard;
    }

    public void setIsAvard(String isAvard) {
        this.isAvard = isAvard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicalLables musicalLables = (MusicalLables) o;
        return Objects.equals(id, musicalLables.id) && Objects.equals(name, musicalLables.name) && Objects.equals(isAvard, musicalLables.isAvard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isAvard);
    }

    public MusicalLables getMusicalLables() {
        return musicalLables;
    }

    public void setMusicalLables(MusicalLables musicalLables) {
        this.musicalLables = musicalLables;
    }
}
