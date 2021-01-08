package com.users.api.integration;

import com.users.api.ApiApplication;
import com.users.api.model.UsersData;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * @author Ola
 * @since 09/01/2021
 */
@SpringBootTest(classes = ApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("default")
public class UsersDataIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testUsersData() {

        UsersData usersData = UsersData
                .builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(usersData)
                .when()
                .post("/users/data")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .body(containsString((usersData.getFirstName())));
    }
}