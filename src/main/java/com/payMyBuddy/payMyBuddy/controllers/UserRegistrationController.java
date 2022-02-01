package com.payMyBuddy.payMyBuddy.controllers;

import java.io.InputStream;
import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public JwtResponse getUsertest(@RequestBody JwtRequest jwt) {
		return userRegistrationService.signIn(jwt);
	}

	@PostMapping("/signup")
	public String signup(@RequestBody User_personnal_informations_DTO user_personnal_informations) {
		return userRegistrationService.createUser(user_personnal_informations);
	}

//	@GetMapping("/login/oauth2/signinByGoogle", produces = "application/json")
	@RequestMapping(value = "/login/oauth2/signinByGoogle", 
	  produces = "application/json", 
	  method=RequestMethod.GET)
	public Principal signinByGoogle(Principal user) {  
		System.out.println("!!!!!!!!!!!!!!!" + user);

		return user;
	}
	
	@PostMapping("/login/oauth2/code/google")
	public Principal prr(Principal user_personnal_informations) {
		return user_personnal_informations;
	}
	

}
