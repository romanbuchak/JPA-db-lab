package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.AuthorNotFoundException;
import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import com.rbvgt.lab5.jpa.repository.AlbumOfSongRepository;
import com.rbvgt.lab5.jpa.service.AlbumOfSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumOfSongServiceImpl implements AlbumOfSongService {

    @Autowired
    AlbumOfSongRepository albumOfSongRepository;

    @Override
    public List<AlbumOfSong> findAlbumOfSongByName(String name) {
        return albumOfSongRepository.findAlbumOfSongByName(name);
    }

    @Override
    public List<AlbumOfSong> findAll() {
        return albumOfSongRepository.findAll();
    }

    @Override
    public AlbumOfSong findById(Integer id) {
        return albumOfSongRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Transactional
    public AlbumOfSong create(AlbumOfSong albumOfSong) {
        albumOfSongRepository.save(albumOfSong);
        return albumOfSong;
    }

    @Transactional
    public void update(Integer id, AlbumOfSong uAlbumOfSong) {
        AlbumOfSong albumOfSong = albumOfSongRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        //update
        albumOfSong.setId(uAlbumOfSong.getId());
        albumOfSong.setQuantity(uAlbumOfSong.getQuantity());
        albumOfSong.setName(uAlbumOfSong.getName());

        albumOfSongRepository.save(albumOfSong);
    }

    @Transactional
    public void delete(Integer id) {
        AlbumOfSong albumOfSong = albumOfSongRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        albumOfSongRepository.delete(albumOfSong);
    }
}
