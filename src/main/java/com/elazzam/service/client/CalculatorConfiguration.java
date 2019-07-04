package com.elazzam.service.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/*
 * Spring WS uses Spring Framework’s OXM module which has the Jaxb2Marshaller to serialize and deserialize XML requests.
 * The marshaller is pointed at the collection of generated domain objects and will use them to both serialize and deserialize between XML and POJOs.

The countryClient is created and configured with the URI of the country service shown up above. It is also configured to use the JAXB marshaller.
 */
@Configuration
public class CalculatorConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("CalculatorService.wsdl");
		return marshaller;
	}

	@Bean
	public CalculatorClient countryClient(Jaxb2Marshaller marshaller) {
		CalculatorClient client = new CalculatorClient();
		client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}