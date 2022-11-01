package com.rbvgt.lab5.jpa.exception;

public class ServiceUserNotFoundException extends RuntimeException {
    public ServiceUserNotFoundException(Integer id) {
        super("Could not find 'serviceUser' with id = " + id);
    }
}
