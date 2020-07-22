package com.microservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

// to get the user details 

@CrossOrigin(origins = "*")
@RequestMapping(method = RequestMethod.GET, value = "/api/users/{name}/chat", produces = "application/json")
public UserObject getuserdetails(@PathVariable(value = "name") String username) {

	
	return this.userdao.getuserdetails(username);
}


// save user details : 

@CrossOrigin(origins = "*")
@RequestMapping(method = RequestMethod.POST, value = "/api/userdetails/chat", produces = "application/json")
public void saveuserdetails(@Valid @RequestBody UserObject userobj) {
	this.userdao.saveUserDetails(userobj);
}

	

}
