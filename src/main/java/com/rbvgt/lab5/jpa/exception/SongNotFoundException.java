package com.rbvgt.lab5.jpa.exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(Integer id) {
        super("Could not find 'song' with id = " + id);
    }
}
