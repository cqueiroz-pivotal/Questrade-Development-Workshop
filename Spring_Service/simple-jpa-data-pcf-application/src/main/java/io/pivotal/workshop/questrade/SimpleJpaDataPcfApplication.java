package io.pivotal.workshop.questrade;

import io.pivotal.workshop.questrade.model.Customer;
import io.pivotal.workshop.questrade.repo.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleJpaDataPcfApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SimpleJpaDataPcfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaDataPcfApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			
			// save a couple of customers
			repository.save(new Customer("Oleg", "Gorodnitchi"));
			repository.save(new Customer("Muji", "Qadri"));
			repository.save(new Customer("Louis", "Lo"));
			repository.save(new Customer("Luke", "Shannon"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Lo'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Lo")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
	}
}
