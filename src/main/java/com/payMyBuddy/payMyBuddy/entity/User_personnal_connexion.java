package com.payMyBuddy.payMyBuddy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_personnal_connexion")
public class User_personnal_connexion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_personnal_connexion_id;
	
	@OneToOne
	User_personnal_informations user_personnal_informations;
	
	String email;
	
	String password;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	User_role user_role;
	
	List<String> social_network;
	
}
