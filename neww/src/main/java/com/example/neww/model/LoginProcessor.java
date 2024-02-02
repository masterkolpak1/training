package com.example.neww.model;

import com.example.neww.services.LoginSaver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import com.example.neww.services.AuthorizationService;

@Component
@RequestScope
public class LoginProcessor {

    private final LoginSaver loginsaver;
    private final AuthorizationService authorizationService;
    private String username;
    private String password;

    public LoginProcessor(LoginSaver loginsaver, AuthorizationService authorizationService) {
        this.loginsaver = loginsaver;
        this.authorizationService = authorizationService;
    }

    public String login() {
        String username = this.getUsername();
        String password = this.getPassword();

        String loginResult = authorizationService.Authorization(username, password);
        if (!loginResult.equals("not")) {
            loginsaver.setUsername(username);
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
