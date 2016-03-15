package io.pivotal.fe.demo;

import io.pivotal.workshop.questrade.SimpleJpaDataPcfApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleJpaDataPcfApplication.class)
@WebAppConfiguration
public class SimpleJpaDataPcfApplicationTests {

	@Test
	public void contextLoads() {
	}

}
