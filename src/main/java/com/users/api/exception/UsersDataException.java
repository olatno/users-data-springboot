package com.users.api.exception;

/**
 * UsersDataException class - custom exception for user's data
 *
 * @author ola
 * @since 06/01/2021.
 */
public class UsersDataException extends RuntimeException {

    public UsersDataException(String message) {
        super(message);
    }
}