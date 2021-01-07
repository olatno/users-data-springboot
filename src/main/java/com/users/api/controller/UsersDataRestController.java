package com.users.api.controller;

import com.users.api.exception.UsersDataException;
import com.users.api.model.UsersData;
import com.users.api.service.UsersDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UsersDataRestController {

    private static final Logger LOG = LoggerFactory.getLogger(UsersDataRestController.class);
    private final UsersDataService usersDataService;

    @Autowired
    public UsersDataRestController(UsersDataService usersDataService){
        Assert.notNull(usersDataService, "UsersDataService must not be null!");
        this.usersDataService = usersDataService;
    }

    @PostMapping("users/data")
    ResponseEntity<UsersData> save(@RequestBody UsersData jsonData) {
        UsersData usersData = null;
        try {
            usersData =  usersDataService.saveEncryptedData(jsonData);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.ALL_VALUE)
                    .body(usersData);
        } catch (UsersDataException ex) {
            LOG.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usersData);
        }
    }
}
