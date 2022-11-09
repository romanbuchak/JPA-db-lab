package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.GenreDto;
import com.rbvgt.lab5.jpa.dto.assembler.GenreDtoAssembler;
import com.rbvgt.lab5.jpa.model.Genre;
import com.rbvgt.lab5.jpa.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;
    @Autowired
    public GenreDtoAssembler genreDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<GenreDto>> getAll() {
        List<Genre> genres = genreService.findAll();
        CollectionModel<GenreDto> genreDtos = genreDtoAssembler.toCollectionModel(genres);
        return new ResponseEntity<>(genreDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GenreDto> getById(@PathVariable Integer id) {
        Genre genre= genreService.findById(id);
        GenreDto genreDto = genreDtoAssembler.toModel(genre);
        return new ResponseEntity<>(genreDto, HttpStatus.OK);
    }

    @GetMapping(value = "/type/{type}")
    public ResponseEntity<CollectionModel<GenreDto>> getGenreByType(@PathVariable String type) {
        List<Genre> genre = genreService.findGenreByType(type);
        CollectionModel<GenreDto> genreDtos = genreDtoAssembler.toCollectionModel(genre);
        return new ResponseEntity<>(genreDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenreDto> create(@RequestBody Genre genre) {
        Genre newGenre = genreService.create(genre);
        GenreDto genreDto = genreDtoAssembler.toModel(newGenre);
        return new ResponseEntity<>(genreDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Genre uGenre, @PathVariable Integer id) {
        genreService.update(id, uGenre);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/cursor")
    public ResponseEntity<?> createTablesWithCursor() {
        genreService.createTablesWithCursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        genreService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
