package com.payMyBuddy.payMyBuddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.payMyBuddy.payMyBuddy.entity.ERole;
import com.payMyBuddy.payMyBuddy.entity.User;
import com.payMyBuddy.payMyBuddy.entity.User_address;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;
import com.payMyBuddy.payMyBuddy.entity.User_role;
import com.payMyBuddy.payMyBuddy.repository.UserRepository;
import com.payMyBuddy.payMyBuddy.repository.User_roleRepository;


@SpringBootApplication
public class PayMyBuddyApplication extends SpringBootServletInitializer {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PayMyBuddyApplication.class);
	}

	@Bean
	public CommandLineRunner start(UserRepository userRepository, User_roleRepository user_repository) {
		return args -> {
			userRepository.deleteAll();
			if (org.springframework.util.CollectionUtils.isEmpty(userRepository.findAll())) {
//				User_role roleClient = new User_role(null, ERole.ROLE_CLIENT);
//				user_repository.saveAll(Arrays.asList(roleClient));
//				List<User_role> roles = new ArrayList<>();
//				User_address user_address = new User_address(1, null, "3 rue", 1222, "ville", "France");
//				User_role user_role = new User_role(1, null, "client");
//				User_personnal_informations user_personnal_informations;
//				User_personnal_connexion user_personnal_connexion = new User_personnal_connexion(1, user_personnal_informations, "j.i@g.com",
//						"ff", roles);
//				User user = new User();
//				userRepository.save(user);
			}
		};
	}

}
