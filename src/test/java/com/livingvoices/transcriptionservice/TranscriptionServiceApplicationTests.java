
package com.livingvoices.transcriptionservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;

@SpringBootTest
@Testcontainers
class TranscriptionServiceApplicationTests {

	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> postgres =
			new PostgreSQLContainer<>("postgres:17");

	@Container
	@ServiceConnection
	static RabbitMQContainer rabbitmq =
			new RabbitMQContainer("rabbitmq:4-management");

	@MockitoBean
	JwtDecoder jwtDecoder;

	@Test
	void contextLoads() {
	}
}
