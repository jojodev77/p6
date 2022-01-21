package com.payMyBuddy.payMyBuddy.entity;

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
@Table(name = "user_personnal_informations")
public class User_personnal_informations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_personnal_informations_id;
	
	@OneToOne
	User user;

	String firstName;

	String lastName;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	User_address user_address;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	User_personnal_connexion user_personnal_connexion;
	
	int phone_number;
}
