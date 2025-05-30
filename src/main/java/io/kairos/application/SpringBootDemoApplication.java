package io.kairos.application;

import io.kairos.application.model.Alien;
import io.kairos.application.model.Laptop;
import io.kairos.application.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		LaptopService laptopService = context.getBean(LaptopService.class);
		Laptop laptop = context.getBean(Laptop.class);

		laptopService.addLaptop(laptop);
	}

}
