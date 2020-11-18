package com.example.auto_garage.exceptions;

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException(String userName) {
        super("Cannot find user " + userName);
    }

}
