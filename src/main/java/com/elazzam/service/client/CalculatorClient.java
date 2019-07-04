package com.elazzam.service.client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import CalculatorService.wsdl.Add;
import CalculatorService.wsdl.AddResponse;

/*
 * The client contains one method: getGetBLZServiceResponse which does the actual SOAP exchange.
 */
public class CalculatorClient  extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

	public AddResponse getCalculatorResponse(int a, int b) {

		Add request = new Add();
		request.setIntA(a);
		request.setIntB(b);
		

		log.info("Requesting sum of " + a + " and " + b);

		AddResponse response = (AddResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
						new SoapActionCallback(
								"http://tempuri.org/Add"));

		return response;
	}

}



