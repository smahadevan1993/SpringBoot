package com.microservice.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.objects.Helloobjects;



@RestController
public class Hello {
	
	
	private static final String template = "Hello, %s!";

	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/getdetailsexample", produces = "application/json")
	//@GetMapping("/greeting")
	public Helloobjects getdetails(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		
		return new Helloobjects(String.format(template, name));
		
	}
	

}
