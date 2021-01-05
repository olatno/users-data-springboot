package com.users.api.service.impl;

import com.users.api.model.UsersData;
import com.users.api.repository.UsersDataRepository;
import com.users.api.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersDataServiceImpl implements UsersDataService {

    private final UsersDataRepository usersDataRepository;

    @Autowired
    public UsersDataServiceImpl(UsersDataRepository usersDataRepository){
        this.usersDataRepository = usersDataRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersData saveEncryptedData(UsersData usersData){
        usersDataRepository.save(usersData);
        return usersDataRepository.getOne(usersData.getId());
    }
}
