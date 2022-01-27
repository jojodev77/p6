package com.payMyBuddy.payMyBuddy.services;

import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.User_account_informations_DTO;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;

@Service
public class UserAccountRegistrationService {

	public User_account_informations_DTO userRegistrationAccount(User_personnal_informations user_personnal_informations ) {
		User_account_informations_DTO user_account_informations_DTO = new User_account_informations_DTO();
		user_account_informations_DTO.setSold_account(0);
		user_account_informations_DTO.setAccount_reference_transaction(attributeAccount_reference_transaction(user_personnal_informations));
		
		return user_account_informations_DTO;
	}
	
	private String attributeAccount_reference_transaction(User_personnal_informations user_personnal_informations_dto) {
		String account_reference_transaction = "pmb" + user_personnal_informations_dto.getFirstName().substring(0, 1) + user_personnal_informations_dto.getFirstName().substring(0, 2) + user_personnal_informations_dto.getId() + "b";
		return account_reference_transaction;
	}
	
	
 }
