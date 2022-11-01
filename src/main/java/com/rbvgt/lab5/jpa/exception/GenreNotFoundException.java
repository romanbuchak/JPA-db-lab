package com.rbvgt.lab5.jpa.exception;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(Integer id) {
        super("Could not find 'genre' with id = " + id);
    }
}
