package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.AlbumOfSongDto;
import com.rbvgt.lab5.jpa.dto.assembler.AlbumOfSongDtoAssembler;
import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import com.rbvgt.lab5.jpa.service.AlbumOfSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/albumOfSong")
public class AlbumOfSongController {
    @Autowired
    private AlbumOfSongService albumOfSongService;
    @Autowired
    public AlbumOfSongDtoAssembler albumOfSongDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<AlbumOfSongDto>> getAll() {
        List<AlbumOfSong> albumOfSongs = albumOfSongService.findAll();
        CollectionModel<AlbumOfSongDto> albumOfSongDtos = albumOfSongDtoAssembler.toCollectionModel(albumOfSongs);
        return new ResponseEntity<>(albumOfSongDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlbumOfSongDto> getById(@PathVariable Integer id) {
        AlbumOfSong albumOfSong = albumOfSongService.findById(id);
        AlbumOfSongDto albumOfSongDto = albumOfSongDtoAssembler.toModel(albumOfSong);
        return new ResponseEntity<>(albumOfSongDto, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<CollectionModel<AlbumOfSongDto>> getAlbumOfSongByName(@PathVariable String name) {
        List<AlbumOfSong> albumOfSongs = albumOfSongService.findAlbumOfSongByName(name);
        CollectionModel<AlbumOfSongDto> albumOfSongDtos = albumOfSongDtoAssembler.toCollectionModel(albumOfSongs);
        return new ResponseEntity<>(albumOfSongDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AlbumOfSongDto> create(@RequestBody AlbumOfSong albumOfSong) {
        AlbumOfSong newAlbumOfSong = albumOfSongService.create(albumOfSong);
        AlbumOfSongDto albumOfSongDto = albumOfSongDtoAssembler.toModel(newAlbumOfSong);
        return new ResponseEntity<>(albumOfSongDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody AlbumOfSong uAlbumOfSong, @PathVariable Integer id) {
        albumOfSongService.update(id, uAlbumOfSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        albumOfSongService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
