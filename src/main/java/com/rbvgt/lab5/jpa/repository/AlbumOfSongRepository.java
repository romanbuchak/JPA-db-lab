package com.rbvgt.lab5.jpa.repository;

import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlbumOfSongRepository extends JpaRepository<AlbumOfSong, Integer> {
    List<AlbumOfSong> findAlbumOfSongByName(String name);
}
