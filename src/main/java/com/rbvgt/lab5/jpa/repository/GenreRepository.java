package com.rbvgt.lab5.jpa.repository;

import com.rbvgt.lab5.jpa.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findGenreByType(String type);
}
