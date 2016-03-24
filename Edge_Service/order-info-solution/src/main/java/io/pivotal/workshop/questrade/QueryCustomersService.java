package io.pivotal.workshop.questrade;

import java.net.URI;
import java.util.List;

import io.pivotal.workshop.questrade.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class QueryCustomersService {

        @Autowired
        private RestTemplate restTemplate;

        Logger logger = LoggerFactory
                        .getLogger(QueryCustomersService.class);

        public Customer[] queryCustomers() {

                Customer[] customers = restTemplate.getForObject("https://customer-service/customers", Customer[].class);
                return customers;
        }

}
