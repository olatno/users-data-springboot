package com.users.api.model;

import com.users.api.encryptor.UsersDataEncryptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UsersData {

    @Convert(converter = UsersDataEncryptor.class)
    private String firstName;

    @Convert(converter = UsersDataEncryptor.class)
    private String lastName;

    @Convert(converter = UsersDataEncryptor.class)
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
