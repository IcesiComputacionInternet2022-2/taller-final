package com.edu.icesi.virtualshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@Import({com.edu.icesi.virtualshop.config.InitialDataConfig.class})
@EnableJpaRepositories
public class VirtualshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualshopApplication.class, args);
	}

}
