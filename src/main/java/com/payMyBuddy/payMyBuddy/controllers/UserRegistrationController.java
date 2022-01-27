package com.payMyBuddy.payMyBuddy.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payMyBuddy.payMyBuddy.dto.JwtRequest;
import com.payMyBuddy.payMyBuddy.dto.JwtResponse;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.services.UserRegistrationService;

@RestController
@RequestMapping
public class UserRegistrationController {
	

	@Autowired
	UserRegistrationService userRegistrationService;
	
//	  @RolesAllowed("CLIENT")
//	   @RequestMapping("/**")
//	   public String getUser()
//	   {
//	      return "Welcome User";
//	   }
	  
	  @PostMapping("/signin")
	  public JwtResponse getUsertest(@RequestBody JwtRequest jwt){
	      return userRegistrationService.signIn(jwt);
	   }
	  
	  @PostMapping("/signup")
	  public String signup(@RequestBody User_personnal_informations_DTO user_personnal_informations) {
		  return userRegistrationService.createUser(user_personnal_informations);
	  }
}
