package com.payMyBuddy.payMyBuddy.entity;

import javax.persistence.Entity;
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
@Table(name = "user_address")
public class User_address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_address_id;
	
	@OneToOne
	User_personnal_informations user_personnal_informations;
	
	String street;
	
	int postal_number;
	
	String city;
	
	String state;
	
}
