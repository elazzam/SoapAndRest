package com.elazzam.soap.endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.elazzam.repository.CountryRepository;

/*
 * In all of these chunks of code, the io.spring.guides classes will report compile-time errors in your IDE 
 * unless you have run the task to generate the domain classes based on the WSDL.
 */
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

/*
 * @Endpoint registers the class with Spring WS as a potential candidate for processing incoming SOAP messages.
 */
@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	/*
	 * @PayloadRoot is then used by Spring WS to pick the handler method based on the message’s namespace and localPart.
	 * @RequestPayload indicates that the incoming message will be mapped to the method’s request parameter.
	 * The @ResponsePayload annotation makes Spring WS map the returned value to the response payload.
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}