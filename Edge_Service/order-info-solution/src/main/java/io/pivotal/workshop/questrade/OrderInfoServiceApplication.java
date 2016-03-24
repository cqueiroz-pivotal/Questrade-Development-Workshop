package io.pivotal.workshop.questrade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class OrderInfoServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OrderInfoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderInfoServiceApplication.class, args);
	}

}
