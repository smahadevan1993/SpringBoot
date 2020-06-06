package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.objects.Helloobjects;
import com.microservice.objects.UserObject;
import com.microservice.repository.UserDao;


@RestController
@EnableAutoConfiguration
public class Users {
	
	
@Autowired
private UserDao userdao;


@CrossOrigin(origins = "*")
@RequestMapping(method = RequestMethod.GET, value = "/api/users/{id}/chat", produces = "application/json")
public UserObject getuserdetails(@PathVariable(value = "id") String userid) {

	
	return this.userdao.getuserdetails(userid);
}
	

}
