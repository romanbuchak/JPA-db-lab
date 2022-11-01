package com.rbvgt.lab5.jpa.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Integer id) {
        super("Could not find 'author' with id = " + id);
    }
}
