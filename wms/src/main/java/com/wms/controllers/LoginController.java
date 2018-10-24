package com.wms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.beans.User;
import com.wms.beans.UserActionStatus;
import com.wms.service.LoginService;;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/user/signup")	
	public ResponseEntity<UserActionStatus> retrieveCoursesForStudent(@PathVariable User user) {
		//Validate all the required parameters. Add methods in util class
		//http://websystique.com/spring-boot/spring-boot-rest-api-example/
		
		UserActionStatus status = loginService.signUp(user);
		
		if(status.isStatus()) {
			return new ResponseEntity<UserActionStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<UserActionStatus>(HttpStatus.NO_CONTENT);
	}
}
