package com.users.api.encryptor;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

/**
 * UsersDataEncryptor class - encrypt user's data when saved to db and decrypt user's data when requested from db
 *
 * @author Ola
 * @since 06/01/2021
 */

@Component
public class UsersDataEncryptor implements AttributeConverter<String, String> {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "my-secret-key-00";

    private final Key securityKey;
    private final Cipher cipherObject;

    public UsersDataEncryptor() throws Exception {
        securityKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipherObject = Cipher.getInstance(ALGORITHM);
    }

    @Override
    public String convertToDatabaseColumn(String databaseData) {
        try {
            cipherObject.init(Cipher.ENCRYPT_MODE, securityKey);
            return Base64.getEncoder().encodeToString(cipherObject.doFinal(databaseData.getBytes()));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String usersData) {
        try {
            cipherObject.init(Cipher.DECRYPT_MODE, securityKey);
            return new String(cipherObject.doFinal(Base64.getDecoder().decode(usersData)));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
