package com.example.neww;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.neww.services.LoginSaver;
import com.example.neww.model.LoginProcessor;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class LoginProcessorIntegrationTests {
    @MockBean
    private LoginSaver loginSaver;

    @Autowired
    private LoginProcessor loginProcessor;

    @Test
    public void loginSuccessInt() {
        loginProcessor.setUsername("Moder");
        loginProcessor.setPassword("modpas");
        String result = loginProcessor.login();
        assertEquals("moderator", result);
        verify(loginSaver).setUsername("Moder");
    }
}