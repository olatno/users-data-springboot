package com.users.api.service.impl;

import com.users.api.exception.UsersDataException;
import com.users.api.model.UsersData;
import com.users.api.repository.UsersDataRepository;
import com.users.api.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Service
public class UsersDataServiceImpl implements UsersDataService {

    private final UsersDataRepository usersDataRepository;

    @Autowired
    public UsersDataServiceImpl(UsersDataRepository usersDataRepository){
        Assert.notNull(usersDataRepository, "UsersDataRepository must not be null!");
        this.usersDataRepository = usersDataRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersData saveEncryptedData(UsersData usersData) throws UsersDataException {
        if(StringUtils.hasText(usersData.getFirstName()) && StringUtils.hasText(usersData.getFirstName())){
            throw new UsersDataException("Firstname and email address are mandatory");
        }
        usersDataRepository.save(usersData);
        return usersDataRepository.getOne(usersData.getId());
    }
}
