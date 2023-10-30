package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class IntroductionApplicationTests {
	
	@Autowired
	private PasswordEncoder encoder;

	@Test
	void contextLoads() {
		
			System.out.println(encoder.encode("pwd1"));
		
	}

}
