package com.payMyBuddy.payMyBuddy.dto;

import com.payMyBuddy.payMyBuddy.entity.User;

import lombok.Data;

@Data
public class User_personnal_informations_DTO {
	long user_personnal_informations_id;
	String firstName;
	String lastName;
	int phone_number;
	User_address_DT0 user_address;
	public User_personnal_connexion_DTO user_personnal_connexion;
}
