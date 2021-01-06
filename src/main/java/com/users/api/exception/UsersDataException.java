package com.users.api.exception;

/**
 * GalleryServiceException class
 *
 * @author ola
 * @since 14/11/2020.
 */
public class UsersDataException extends RuntimeException {

    public UsersDataException(String message) {
        super(message);
    }
}