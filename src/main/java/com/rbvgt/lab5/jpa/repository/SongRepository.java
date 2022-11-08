package com.rbvgt.lab5.jpa.repository;

import com.rbvgt.lab5.jpa.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findSongByName(String name);

    @Procedure("SongParamInsert")
    Song createSongWithProcedure(String name);
}
