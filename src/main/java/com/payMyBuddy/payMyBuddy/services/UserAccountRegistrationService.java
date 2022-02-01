package com.payMyBuddy.payMyBuddy.services;

import org.springframework.stereotype.Service;

import com.payMyBuddy.payMyBuddy.dto.User_account_informations_DTO;
import com.payMyBuddy.payMyBuddy.dto.User_personnal_informations_DTO;
import com.payMyBuddy.payMyBuddy.entity.User_account_informations;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;

@Service
public class UserAccountRegistrationService {

	public User_account_informations attributeAccountInformations(User_personnal_informations user_personnal_informations_dto) {
		User_account_informations user_account_informations = new User_account_informations();
		user_account_informations.setSold_account(0);
		String account_reference_transaction = "pmb" + user_personnal_informations_dto.getFirstName().substring(0, 1) + user_personnal_informations_dto.getFirstName().substring(0, 2) + user_personnal_informations_dto.getId() + "b";
		user_account_informations.setAccount_reference_transaction(account_reference_transaction);
		return user_account_informations;
	}
 }
