package com.elazzam;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.elazzam.service.client.CalculatorClient;

import BLZService.wsdl.GetBankResponseType;
import CalculatorService.wsdl.Add;
import CalculatorService.wsdl.AddResponse;


/*
 * In Spring Boot, to create a WAR for deployment, we need 3 steps:

Extends SpringBootServletInitializer
Marked the embedded servlet container as provided. <scope>provided</scope>
Update packaging to war
 */

@SpringBootApplication
public class Application  extends SpringBootServletInitializer {

	/*
	 * The main() method defers to the SpringApplication helper class, providing CountryConfiguration.class 
	 * as an argument to its run() method. 
	 * This tells Spring to read the annotation metadata from CountryConfiguration and to manage it as a component in the Spring application context.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
	
	/*
	 * just for verification purpose that the soap webservice called has been consumed successfully 
	 */
	@Bean
	CommandLineRunner addition(CalculatorClient addClient) {
		return args -> {
			
			int a = 1;
			int b = 2;

			AddResponse response = addClient.getCalculatorResponse(a, b);
			System.err.println(a + "+" + b + "=" + response.getAddResult());
		};
	}
}