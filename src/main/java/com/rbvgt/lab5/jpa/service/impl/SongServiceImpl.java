package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.SongNotFoundException;
import com.rbvgt.lab5.jpa.model.Song;
import com.rbvgt.lab5.jpa.repository.SongRepository;
import com.rbvgt.lab5.jpa.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public List<Song> findSongByName(String name) {
        return songRepository.findSongByName(name);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    @Override
    public Song createSongWithProcedure(String name) {
        return songRepository.createSongWithProcedure(name);
    }

//    @Override
//    public void createSongAuthorRelationship(String songName, String authorName) {
//        songRepository.createSongAuthorRelationship(songName, authorName);
//    }

    @Transactional
    public Song create(Song song) {
        songRepository.save(song);
        return song;
    }

    @Transactional
    public void update(Integer id, Song uSong) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
        //update
        song.setId(uSong.getId());
        song.setName(uSong.getName());

        songRepository.save(uSong);
    }

    @Transactional
    public void delete(Integer id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
        songRepository.delete(song);
    }
}
