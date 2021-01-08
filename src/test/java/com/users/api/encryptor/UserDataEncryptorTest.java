package com.users.api.encryptor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ola
 * @since 08/01/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataEncryptorTest {

    private final String EMAIL_COLUMN = "admin@ymail.com";
    private final String ENCODED = "gqb7xWFWPwl44uWYcrhXRQ==";

    @InjectMocks
    private UsersDataEncryptor usersDataEncryptor;


    @Test
    public void testConvertToDatabaseColumn(){
        String encoded = usersDataEncryptor.convertToDatabaseColumn(EMAIL_COLUMN);
        Assert.assertEquals(encoded, ENCODED);
    }

    @Test
    public void testConvertToEntityAttribute() throws Exception{
        String decoded = usersDataEncryptor.convertToEntityAttribute(ENCODED);
        Assert.assertEquals(decoded, EMAIL_COLUMN);
    }
}
