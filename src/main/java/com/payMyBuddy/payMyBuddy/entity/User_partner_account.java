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
@Table(name = "user_partner_account")
public class User_partner_account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@OneToOne
	User_account_informations user_account_informations;
}
