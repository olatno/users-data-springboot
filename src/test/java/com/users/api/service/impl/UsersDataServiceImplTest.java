package com.users.api.service.impl;

import com.users.api.exception.UsersDataException;
import com.users.api.model.UsersData;
import com.users.api.service.UsersDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ola
 * @since 08/01/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersDataServiceImplTest {

    @Autowired
    private UsersDataService usersDataService;

    @Test
    public void testSaveEncryptedData(){
       UsersData usersDataResult = usersDataService.saveEncryptedData(usersData);
        Assert.assertEquals(usersDataResult.getFirstName(), "firstName");
        Assert.assertEquals(usersDataResult.getLastName(), "lastName");
        Assert.assertEquals(usersDataResult.getEmail(), "test@ymail.com");
    }

    @Test(expected = UsersDataException.class)
    public void testSaveEncryptedDataWithException(){
        UsersData usersDataResult = usersDataService.saveEncryptedData(usersDataNoEmail);
        Assert.assertEquals(usersDataResult.getFirstName(), "firstName");
        Assert.assertEquals(usersDataResult.getLastName(), "lastName");
        Assert.assertEquals(usersDataResult.getEmail(), null);
    }

    UsersData usersData = UsersData.builder()
            .firstName("firstName")
            .lastName("lastName")
            .email("test@ymail.com")
            .build();

    UsersData usersDataNoEmail = UsersData.builder()
            .firstName("firstName")
            .lastName("lastName")
            .email(null)
            .build();
}
