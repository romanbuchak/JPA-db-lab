package com.rbvgt.lab5.jpa.service;

import com.rbvgt.lab5.jpa.model.Song;
import java.util.List;

public interface SongService extends GeneralService<Song, Integer>{
    List<Song> findSongByName(String name);
}
