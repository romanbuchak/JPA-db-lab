package com.rbvgt.lab5.jpa.service;

import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import java.util.List;

public interface AlbumOfSongService extends GeneralService<AlbumOfSong, Integer> {
    List<AlbumOfSong> findAlbumOfSongByName(String name);
}
