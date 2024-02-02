package com.example.neww;

import com.example.neww.services.AuthorizationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.neww.services.LoginSaver;
import com.example.neww.model.LoginProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

@SpringBootTest
class LoginProcessorUnitTests {

	@Test
	public void loginSuccess() {
		//тест не проходит потому что "loginResult" is null, потому что база данных это заглушка
		LoginSaver loginSaver = mock(LoginSaver.class);
		AuthorizationService authorizationService = mock(AuthorizationService.class);
		LoginProcessor loginProcessor = new LoginProcessor(loginSaver, authorizationService);
		loginProcessor.setUsername("Moder");
		loginProcessor.setPassword("modpas");
		String result = loginProcessor.login();
		assertEquals("moderator", result);
		verify(loginSaver).setUsername("Moder");
	}

}
