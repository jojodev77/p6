package com.payMyBuddy.payMyBuddy.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.JwtRequest;
import com.payMyBuddy.payMyBuddy.dto.JwtResponse;
import com.payMyBuddy.payMyBuddy.dto.UserRoleDto;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_connexion_DTO;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User;
import com.payMyBuddy.payMyBuddy.entity.User_address;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;
import com.payMyBuddy.payMyBuddy.entity.User_role;
import com.payMyBuddy.payMyBuddy.mapper.UserPersonnalConnexionMapper;
import com.payMyBuddy.payMyBuddy.mapper.User_account_informationsMapper;
import com.payMyBuddy.payMyBuddy.mapper.User_addressMapper;
import com.payMyBuddy.payMyBuddy.mapper.User_personnal_informationsMapper;
import com.payMyBuddy.payMyBuddy.repository.UserRepository;
import com.payMyBuddy.payMyBuddy.repository.User_personnal_connexionRepository;
import com.payMyBuddy.payMyBuddy.repository.User_personnal_informationsRepository;
import com.payMyBuddy.payMyBuddy.repository.User_roleRepository;
import com.payMyBuddy.payMyBuddy.security.AuthTokenFilter;
import com.payMyBuddy.payMyBuddy.security.JwtUtils;
import com.payMyBuddy.payMyBuddy.security.UserDetailsImpl;

@Service
public class UserRegistrationService {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	User_personnal_connexionRepository user_personnal_connexionRepository;

	@Autowired
	UserAccountRegistrationService userAccountRegistrationService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	User_personnal_informationsRepository userPersonnalRepository;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	User_roleRepository user_roleRepository;

	@Autowired
	User_account_informationsMapper user_account_informationsMapper;

	/**
	 * Pattern of validation of password
	 */
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

	public static boolean isValid(final String password) {
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

//	@Transactional( rollbackOn = RuntimeException.class)
	public String createUser(User_personnal_informations_DTO user_personnal_informations_dto) {

		User user = new User();
		User_personnal_informations user_personnal_informations = new User_personnal_informations();
		user_personnal_informations.setFirstName(user_personnal_informations_dto.getFirstName());
		user_personnal_informations.setLastName(user_personnal_informations_dto.getLastName());
		user_personnal_informations.setPhone_number(user_personnal_informations_dto.getPhone_number());
		User_personnal_connexion user_personnal_connexion = new User_personnal_connexion();
		user_personnal_connexion.setEmail(user_personnal_informations_dto.getUser_personnal_connexion().getEmail());
		user_personnal_connexion.setPassword(
				encoder.encode(user_personnal_informations_dto.getUser_personnal_connexion().getPassword()));
		user_personnal_connexion.setUser_personnal_informations(user_personnal_informations);
		User_address userAdress = new User_address();
		userAdress.setStreet(user_personnal_informations_dto.getUser_address().getStreet());
		userAdress.setPostal_number(user_personnal_informations_dto.getUser_address().getPostal_number());
		userAdress.setCity(user_personnal_informations_dto.getUser_address().getCity());
		userAdress.setState(user_personnal_informations_dto.getUser_address().getState());
		userAdress.setUser_personnal_informations(user_personnal_informations);
		// userAdress.setUser_personnal_informations(user_personnal_informationsMapper.toUserPersonnalInformations(user_personnal_informations_dto));
//		
		user_personnal_informations.setUser_address(userAdress);
		user_personnal_informations.setUser_personnal_connexion(user_personnal_connexion);
		user_personnal_informations.setUser(user);
		Optional<User_personnal_connexion> us = Optional.ofNullable(user_personnal_connexionRepository
				.findByEmail(user_personnal_informations_dto.getUser_personnal_connexion().getEmail()));
		if (!us.isPresent()) {
//			if (isValid(user_personnal_informations.getUser_personnal_connexion().getPassword())) {
//				
			user.setUser_personnal_informations(user_personnal_informations);
			user.setUser_account_informations(
					userAccountRegistrationService.attributeAccountInformations(user_personnal_informations));
			user.getUser_account_informations().setUser(user);
			userRepository.save(user);
//			} else {
//				throw new RuntimeException("password format is not valid ");
//			}
//
		} else {
			throw new RuntimeException("user exist in application ");
		}
		return "account creation with success";
	}

	@Transactional
	public User_personnal_connexion loadUserByEmail(String email) throws UsernameNotFoundException {
		System.out.println("!!!!!::::::::::::" + email);
		User_personnal_connexion user = user_personnal_connexionRepository.findByEmail(email);
		Optional<User_personnal_connexion> upc = Optional
				.ofNullable(user_personnal_connexionRepository.findByEmail(email));
		if (!upc.isPresent()) {
			throw new UsernameNotFoundException("user: " + email + "not found");
		} else {
			return user;
		}

	}

	public JwtResponse signIn(JwtRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		
		return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail());
	}
	
	public String signinByGoogle(Principal user){ 
		   return "Welcome, " + user.getName(); 
		   }

	private List<User_role> getRoleList(User_personnal_connexion userDto) {
		List<User_role> roles = new ArrayList<>();
		userDto.getUser_role().forEach(r -> {
			Optional<User_role> optRole = User_roleRepository.findByName(r);
			if (optRole.isPresent()) {
				roles.add(optRole.get());
			}
		});

		return roles;
	}

}
