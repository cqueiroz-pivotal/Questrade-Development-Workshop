package io.pivotal.workshop.questrade;

import java.net.URI;
import java.util.List;

import io.pivotal.workshop.questrade.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class QueryCustomersService {

	private DiscoveryClient discoveryClient;
	private RestTemplate restTemplate = new RestTemplate();
	
	Logger logger = LoggerFactory
			.getLogger(QueryCustomersService.class);

	public Customer[] queryCustomers() {

		URI uri = UriComponentsBuilder.fromUriString("https://customer-service").build().toUri();
		
		logger.debug("customer-service URI = " + uri.toString());
		Customer[] customers = restTemplate.getForObject(uri, Customer[].class);
		return customers;
	}

}
