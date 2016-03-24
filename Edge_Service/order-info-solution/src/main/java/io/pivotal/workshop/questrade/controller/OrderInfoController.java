package io.pivotal.workshop.questrade.controller;

import io.pivotal.workshop.questrade.QueryCustomersService;
import io.pivotal.workshop.questrade.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderInfoController {

	Logger logger = LoggerFactory
			.getLogger(OrderInfoController.class);

	@Autowired
	private QueryCustomersService queryCustomersService;
	
	@RequestMapping("/")
	public String queryCustomer() {
		
		Customer[] customers = queryCustomersService.queryCustomers();
		
		String result = "";
		for (int i=0; i<customers.length; i++) {
			result.concat(customers[i].getFirstName() + " " + customers[i].getLastName());
			if (i < (customers.length-1))
				result.concat(", ");
		}
		return result;
		
	}
	
}
