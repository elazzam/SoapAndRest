package com.elazzam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elazzam.model.Greeting;
import com.elazzam.service.client.CalculatorClient;

import CalculatorService.wsdl.AddResponse;

/*
 * This controller is concise and simple, but there’s plenty going on under the hood.
 * 
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    @Autowired
    CalculatorClient calculator;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	int a = 12;
    	int b = 11;
    	AddResponse response = calculator.getCalculatorResponse(a, b);
		int sum = response.getAddResult();
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
    	return new Greeting(sum, String.format(template, name));
    }
}
