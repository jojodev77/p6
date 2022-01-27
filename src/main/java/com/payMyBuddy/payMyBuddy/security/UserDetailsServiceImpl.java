package com.payMyBuddy.payMyBuddy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;
import com.payMyBuddy.payMyBuddy.repository.User_personnal_connexionRepository;
import com.payMyBuddy.payMyBuddy.repository.User_personnal_informationsRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	User_personnal_connexionRepository userConnexionRepository;
	
	@Autowired
	User_personnal_informationsRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User_personnal_connexion userConnexion = userConnexionRepository.findByEmail(email);

		return UserDetailsImpl.build(userConnexion);
	}

}
