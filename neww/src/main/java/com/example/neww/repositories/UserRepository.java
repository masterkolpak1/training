package com.example.neww.repositories;

import com.example.neww.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storeUser(User user) {
        String sql = "INSERT INTO users VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getLogin(), user.getPassword());
    }

    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setLogin(r.getString("login"));
            rowObject.setPassword(r.getString("password"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }
}
