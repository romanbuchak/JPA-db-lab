package com.rbvgt.lab5.jpa.exception;

public class AlbumOfSongNotFoundException extends RuntimeException {
    public AlbumOfSongNotFoundException(Integer id) {
        super("Could not find 'albumOfSong' with id = " + id);
    }
}
