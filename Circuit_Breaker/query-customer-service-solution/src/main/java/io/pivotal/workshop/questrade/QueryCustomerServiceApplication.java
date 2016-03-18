package io.pivotal.workshop.questrade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class QueryCustomerServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(QueryCustomerServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QueryCustomerServiceApplication.class, args);
	}

}
