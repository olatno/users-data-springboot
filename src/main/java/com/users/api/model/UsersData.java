package com.users.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UsersData {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
