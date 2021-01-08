package com.users.api.service.impl;

import com.users.api.exception.UsersDataException;
import com.users.api.model.UsersData;
import com.users.api.repository.UsersDataRepository;
import com.users.api.service.UsersDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Ola
 * @since 05/01/2021
 */

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
    public UsersData saveEncryptedData(UsersData usersData) throws UsersDataException{
        if(StringUtils.isEmpty(usersData.getEmail()) || StringUtils.isEmpty(usersData.getFirstName())){
            throw new UsersDataException("Firstname and email address are mandatory");
        } else {
            usersDataRepository.save(usersData);
            return usersDataRepository.getOne(usersData.getId());
        }
    }
}
