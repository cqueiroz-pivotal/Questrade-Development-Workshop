package io.pivotal.workshop.questrade;

import io.pivotal.workshop.questrade.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class QueryCustomerService {

	Logger logger = LoggerFactory
			.getLogger(QueryCustomerService.class);

	private RestTemplate restTemplate = new RestTemplate();
	
	@HystrixCommand(fallbackMethod = "queryCustomerFallback")
	public String queryCustomer() {
		
		Customer customer = restTemplate.getForObject("https://customer-service-uncoagulative-brightness.cfapps.pez.pivotal.io/customers/86", Customer.class);
		String fullName = customer.getFirstName() + " " + customer.getLastName();
		return fullName;
	}

	public String queryCustomerFallback() {
		logger.debug("Fallback customer used");
		return "Not available";
	}

}
