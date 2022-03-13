package com.cg.oma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OnlineMobileAppCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMobileAppCmsApplication.class, args);
	}
	@Bean
	RestTemplate getRest() {
		RestTemplate rt=new RestTemplate();
		return rt;
	}
}
