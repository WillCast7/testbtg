package com.btgpactual.ssf;

import com.btgpactual.ssf.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SsfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsfApplication.class, args);
	}
	@Autowired
	private InitializerService initializerService;

	@Bean
	CommandLineRunner init(){
		return args -> {
			initializerService.startInitializer();
		};
	}
}
