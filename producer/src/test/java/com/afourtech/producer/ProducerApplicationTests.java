package com.afourtech.producer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProducerApplicationTests {

	@Autowired
	MaxOfNumbersController controller;

	@Test
	@DisplayName("Test the application is up")
	void smokeTest() {
		assertThat(controller).isNotNull();
	}


}
