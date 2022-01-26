package com.payMyBuddy.payMyBuddy.dto;

import com.payMyBuddy.payMyBuddy.entity.User;

import lombok.Data;

@Data
public class User_personnal_informations_DTO {
	long id;
	String firstName;
	String lastName;
	int phone_number;
	User_address_DT0 user_address_DTO;
	public User_personnal_connexion_DTO user_personnal_connexion_DTO;
	User_account_informations_DTO user_account_informations_DTO;
}
