package com.rbvgt.lab5.jpa.exception;

public class UserCardNotFoundException extends RuntimeException {
    public UserCardNotFoundException(Integer id) {
        super("Could not find 'userCard' with id = " + id);
    }
}