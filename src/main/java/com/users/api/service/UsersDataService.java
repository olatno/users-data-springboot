package com.users.api.service;

import com.users.api.model.UsersData;

public interface UsersDataService {

    /**
     * Save Encrypted data
     *
     * @return void
     */
    UsersData saveEncryptedData(UsersData usersData);
}
