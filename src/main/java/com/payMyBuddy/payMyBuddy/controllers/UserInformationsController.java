package com.payMyBuddy.payMyBuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payMyBuddy.payMyBuddy.dto.JwtRequest;
import com.payMyBuddy.payMyBuddy.dto.JwtResponse;
import com.payMyBuddy.payMyBuddy.entity.User;
import com.payMyBuddy.payMyBuddy.services.UserInformationsService;

@RestController
@RequestMapping
public class UserInformationsController {
	
@Autowired
UserInformationsService userInformationsService;

@PostMapping("/getInformations")
public User getUsertest(@RequestBody String email) {
	return userInformationsService.getUserInformations(email);
}
}
