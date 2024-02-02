package com.example.neww.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import com.example.neww.model.User;
import java.util.List;

public interface InterfaceUserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT * FROM users WHERE login = :login AND password = :password")
    List<User> findPost(String login, String password);
}