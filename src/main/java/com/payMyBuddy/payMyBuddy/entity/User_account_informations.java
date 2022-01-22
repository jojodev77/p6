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
@Table(name = "user_account_informations")
public class User_account_informations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_account_informations_id;
	
	@OneToOne
	User user;
	
	String account_reference_transaction;
	
	int number_account;
	
	double sold_account;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	User_partner_account user_partner_account;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	History_transaction history_transaction;
	
	boolean state;
	
	
}
