package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.SongDto;
import com.rbvgt.lab5.jpa.dto.assembler.SongDtoAssembler;
import com.rbvgt.lab5.jpa.model.Song;
import com.rbvgt.lab5.jpa.service.SongService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    public SongDtoAssembler songDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<SongDto>> getAll() {
        List<Song> songs = songService.findAll();
        CollectionModel<SongDto> songDtos = songDtoAssembler.toCollectionModel(songs);
        return new ResponseEntity<>(songDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SongDto> getById(@PathVariable Integer id) {
        Song song= songService.findById(id);
        SongDto songDto = songDtoAssembler.toModel(song);
        return new ResponseEntity<>(songDto, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<CollectionModel<SongDto>> getSongByName(@PathVariable String name) {
        List<Song> song = songService.findSongByName(name);
        CollectionModel<SongDto> songDtos = songDtoAssembler.toCollectionModel(song);
        return new ResponseEntity<>(songDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SongDto> create(@RequestBody Song song) {
        Song newSong = songService.create(song);
        SongDto songDto = songDtoAssembler.toModel(newSong);
        return new ResponseEntity<>(songDto, HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping(value = "/procedure_insert")
    public ResponseEntity<SongDto> createSongWithProcedure(@RequestBody Song song) {
        Song newSong = songService.createSongWithProcedure(song.getName());
        SongDto songDto = songDtoAssembler.toModel(newSong);
        return new ResponseEntity<>(songDto, HttpStatus.CREATED);
    }

//    @Transactional
//    @PostMapping(value = "/relationship")
//    public ResponseEntity<?> createSongAuthorRelationship(@RequestBody JSONObject jsonObject) {
//        songService.createSongAuthorRelationship(jsonObject.getAsString("song_name"), jsonObject.getAsString("author_name"));
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Song uSong, @PathVariable Integer id) {
        songService.update(id, uSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
