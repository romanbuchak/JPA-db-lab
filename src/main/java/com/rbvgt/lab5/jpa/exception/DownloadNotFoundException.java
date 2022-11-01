package com.rbvgt.lab5.jpa.exception;

public class DownloadNotFoundException extends RuntimeException {
    public DownloadNotFoundException(Integer id) {
        super("Could not find 'download' with id = " + id);
    }
}
