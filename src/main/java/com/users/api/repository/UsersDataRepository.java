package com.users.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.users.api.model.UsersData;

/**
 * The Users data repository class
 *
 * @author ola
 * @since 14/11/2020.
 */
public interface UsersDataRepository extends JpaRepository<UsersData, Integer>{
}
