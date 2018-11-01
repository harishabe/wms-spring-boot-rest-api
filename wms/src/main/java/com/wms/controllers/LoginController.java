package com.wms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.beans.User;
import com.wms.beans.UserActionStatus;
import com.wms.service.LoginService;;

@Controller
@RequestMapping("user")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="signup", method=RequestMethod.POST)	
	public ResponseEntity<UserActionStatus> signUpWMS(@RequestBody User user) {		
		System.out.println("User:" + user);
		UserActionStatus status = loginService.signUp(user);
		
		if(status.isStatus()) {
			return new ResponseEntity<UserActionStatus>(status,HttpStatus.OK);
		}
		return new ResponseEntity<UserActionStatus>(status,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)	
	public ResponseEntity<UserActionStatus> loginWMS(@RequestBody User user) {		
		System.out.println("User:" + user);
		UserActionStatus status = loginService.login(user);
		System.out.println("Status:" + status.getMessage());
		if(status.isStatus()) {
			return new ResponseEntity<UserActionStatus>(status,HttpStatus.OK);
		}
		return new ResponseEntity<UserActionStatus>(status,HttpStatus.BAD_REQUEST);
	}
}
