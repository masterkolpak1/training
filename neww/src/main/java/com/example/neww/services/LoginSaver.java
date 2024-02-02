package com.example.neww.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoginSaver {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
