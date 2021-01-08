package com.users.api.controller;

import com.users.api.model.UsersData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ola
 * @since 08/01/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersDataRestControllerTest {

    @Autowired
    private UsersDataRestController usersDataRestController;

    @Test
    public void testSave(){
        ResponseEntity<UsersData> result = usersDataRestController.save(usersData);
        Assert.assertEquals(result.getStatusCode().name(), "OK");
        Assert.assertEquals(result.getStatusCode().value(), 200);
    }

    @Test
    public void testSaveEmptyEmail(){
        ResponseEntity<UsersData> result = usersDataRestController.save(usersDataNoEmail);
        Assert.assertEquals(result.getStatusCode().name(), "INTERNAL_SERVER_ERROR");
        Assert.assertEquals(result.getStatusCode().value(), 500);
    }

    UsersData usersData = UsersData.builder()
            .firstName("firstName")
            .lastName("lastName")
            .email("test@ymail.com")
            .build();

    UsersData usersDataNoEmail = UsersData.builder()
            .firstName("firstName")
            .lastName("lastName")
            .email("")
            .build();
}
