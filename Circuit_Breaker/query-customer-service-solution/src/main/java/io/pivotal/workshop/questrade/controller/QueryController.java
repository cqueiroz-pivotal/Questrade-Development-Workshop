package io.pivotal.workshop.questrade.controller;

import io.pivotal.workshop.questrade.QueryCustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

	Logger logger = LoggerFactory
			.getLogger(QueryController.class);

	@Autowired
	private QueryCustomerService queryCustomerService;
	
	@RequestMapping("/")
	public String queryCustomer() {
		
		String result = queryCustomerService.queryCustomer();
		return result;
		
	}
	
}
