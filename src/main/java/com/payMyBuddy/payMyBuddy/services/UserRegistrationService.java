package com.payMyBuddy.payMyBuddy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.JwtRequest;
import com.payMyBuddy.payMyBuddy.dto.JwtResponse;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_connexion_DTO;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;
import com.payMyBuddy.payMyBuddy.entity.User_role;
import com.payMyBuddy.payMyBuddy.mapper.User_account_informationsMapper;
import com.payMyBuddy.payMyBuddy.mapper.User_addressMapper;
import com.payMyBuddy.payMyBuddy.repository.UserRepository;
import com.payMyBuddy.payMyBuddy.repository.User_personnal_connexionRepository;
import com.payMyBuddy.payMyBuddy.repository.User_roleRepository;
import com.payMyBuddy.payMyBuddy.security.JwtUtils;
import com.payMyBuddy.payMyBuddy.security.UserDetailsImpl;








@Service
public class UserRegistrationService {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	User_personnal_connexionRepository user_personnal_connexionRepository;
	
	@Autowired
	User_addressMapper user_addressMapper;
	
	@Autowired
	UserAccountRegistrationService userAccountRegistrationService;
	
	@Autowired
	User_account_informationsMapper user_account_informationsMapper;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	

	

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
		System.out.println("......................§§§§§" + user_personnal_informations_dto);
		User user = new User();
		User_personnal_informations user_personnal_informations = new User_personnal_informations(); 
		Optional<User_personnal_connexion> userInformations = Optional.ofNullable(user_personnal_connexionRepository
				.findByEmail(user_personnal_informations_dto.user_personnal_connexion_DTO.getEmail()));
		if (!userInformations.isPresent()) {
			if (isValid(user_personnal_informations_dto.user_personnal_connexion_DTO.getPassword())) {
				User_personnal_connexion user_personnal_connexion = new User_personnal_connexion();
				user_personnal_connexion.setEmail(user_personnal_informations_dto.user_personnal_connexion_DTO.getEmail());
				user_personnal_connexion.setPassword(encoder.encode(user_personnal_informations_dto.user_personnal_connexion_DTO.getPassword()));
				user_personnal_connexion.setUser_role(getRoleList(user_personnal_informations_dto.user_personnal_connexion_DTO));
				user_personnal_informations.setUser_personnal_connexion(user_personnal_connexion);
				user_personnal_informations.setFirstName(user_personnal_informations_dto.getFirstName());
				user_personnal_informations.setLastName(user_personnal_informations_dto.getLastName());
				user_personnal_informations.setPhone_number(user_personnal_informations_dto.getPhone_number());
				user_personnal_informations.setUser_address(user_addressMapper.toUser_addressEntity(user_personnal_informations_dto.getUser_address_DTO()));
				user.setUser_personnal_informations(user_personnal_informations);
				user.setUser_account_informations(user_account_informationsMapper.toUser_account_informationsEntity(userAccountRegistrationService.userRegistrationAccount(user_personnal_informations_dto)));
				userRepository.save(user);
				System.out.println("......................§§§§§" + user);
			} else {
				throw new RuntimeException("password format is not valid ");
			}

		} else {
			throw new RuntimeException("user exist in application ");
		}
		return "account creation with success";
	}

	@Transactional
	public User_personnal_connexion loadUserByEmail(String email) throws UsernameNotFoundException {
		User_personnal_connexion user = user_personnal_connexionRepository.findByEmail(email);
		Optional<User_personnal_connexion> upc = Optional.ofNullable(user_personnal_connexionRepository.findByEmail(email));
		if (!upc.isPresent()) {
			throw new UsernameNotFoundException("user: " + email + "not found");
		} else {
			return user;
		}

	}
	
	
	
	public JwtResponse signIn(JwtRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmaill(), loginRequest.getPssword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),userDetails.getEmail());
	}
	



	private List<User_role> getRoleList(User_personnal_connexion_DTO userDto) {
		List<User_role> roles = new ArrayList<>();
		userDto.getRoles().forEach(r -> {
			Optional<User_role> optRole = User_roleRepository.findByName(r);
			if (optRole.isPresent()) {
				roles.add(optRole.get());
			}
		});

		return roles;
	}

}
