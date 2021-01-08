package com.users.api.service;

import com.users.api.exception.UsersDataException;
import com.users.api.model.UsersData;

/**
 * The user's data service class
 *
 * @author Ola
 * @since 05/01/2021
 */
public interface UsersDataService {

    /**
     * Save Encrypted data
     *
     * @return void
     */
    UsersData saveEncryptedData(UsersData usersData) throws UsersDataException ;
}
