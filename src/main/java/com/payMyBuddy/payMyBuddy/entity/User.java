package com.payMyBuddy.payMyBuddy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	User_personnal_informations user_personnal_informations;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	User_account_informations user_account_informations;
}
