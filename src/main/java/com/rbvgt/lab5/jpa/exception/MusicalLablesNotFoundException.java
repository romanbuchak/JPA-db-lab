package com.rbvgt.lab5.jpa.exception;

public class MusicalLablesNotFoundException extends RuntimeException {
    public MusicalLablesNotFoundException(Integer id) {
        super("Could not find 'musicalLables' with id = " + id);
    }
}
