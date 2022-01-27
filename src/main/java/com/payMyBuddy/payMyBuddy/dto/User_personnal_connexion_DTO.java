package com.payMyBuddy.payMyBuddy.dto;

import java.util.List;

import com.payMyBuddy.payMyBuddy.entity.ERole;
import com.payMyBuddy.payMyBuddy.entity.User_role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User_personnal_connexion_DTO {
	 Long id;
	 String userName;
	 String email;
	 String password;
	 List<ERole> roles;

}
