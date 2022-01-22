package com.payMyBuddy.payMyBuddy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.entity.History_transaction;
import com.payMyBuddy.payMyBuddy.entity.User;
import com.payMyBuddy.payMyBuddy.entity.User_account_informations;
import com.payMyBuddy.payMyBuddy.entity.User_address;
import com.payMyBuddy.payMyBuddy.entity.User_partner_account;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;
import com.payMyBuddy.payMyBuddy.entity.User_role;

@Service
public class Inject_data_SQL {

	public User createUser() {
		User user = new User(1, createUser_personnal_informations(), createUser_account_informations());
		return null;
		
	}
	
	public User_role createUser_role() {
		User_role user_role = new User_role(1, createUser_personnal_connexion(), "client");
		return null;
	}
	
	public User_personnal_informations createUser_personnal_informations() {
		User_personnal_informations user_personnal_informations = new User_personnal_informations(1, createUser(), "jonathan", "delaosa", createUser_address(), createUser_personnal_connexion(), 011);
		return null;
	}
	
	public User_personnal_connexion createUser_personnal_connexion() {
		User_personnal_connexion user_personnal_connexion = new User_personnal_connexion(1, createUser_personnal_informations(), "j.i@g.com", "ff", createUser_role(), List.of("fb")); 
		return null;
	}
	
	public User_partner_account createUser_partner_account() {
		return null;
	}
	
	public User_address createUser_address() {
		return null;
	}
	
	public User_account_informations createUser_account_informations() {
		return null;
	}
	
	public History_transaction createHistory_transaction() {
		return null;
	}
}
