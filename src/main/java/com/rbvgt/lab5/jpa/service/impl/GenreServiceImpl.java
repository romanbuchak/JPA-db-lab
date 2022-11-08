package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.GenreNotFoundException;
import com.rbvgt.lab5.jpa.model.Genre;
import com.rbvgt.lab5.jpa.repository.GenreRepository;
import com.rbvgt.lab5.jpa.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<Genre> findGenreByType(String type) {
        return genreRepository.findGenreByType(type);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Integer id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
    }

    @Override
    public void createTablesWithCursor() {
        genreRepository.createTablesWithCursor();
    }

    @Transactional
    public Genre create(Genre genre) {
        genreRepository.save(genre);
        return genre;
    }

    @Transactional
    public void update(Integer id, Genre uGenre) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
        //update
        genre.setId(uGenre.getId());
        genre.setType(uGenre.getType());

        genreRepository.save(uGenre);
    }

    @Transactional
    public void delete(Integer id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
        genreRepository.delete(genre);
    }
}
