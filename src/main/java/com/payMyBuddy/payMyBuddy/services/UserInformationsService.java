package com.payMyBuddy.payMyBuddy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.entity.User;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.repository.UserRepository;
import com.payMyBuddy.payMyBuddy.repository.User_personnal_connexionRepository;

@Service
public class UserInformationsService {

	@Autowired
	User_personnal_connexionRepository userPersonalRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public User getUserInformations(String email) {
Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
if (!user.isPresent()) {
	throw new RuntimeException("zero user found");
}
		return user.get();
	}
	
}
