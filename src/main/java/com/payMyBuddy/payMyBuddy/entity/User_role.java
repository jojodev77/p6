package com.payMyBuddy.payMyBuddy.entity;

import java.util.List;

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
@Table(name = "user_role")
public class User_role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_role_id;
	
	@OneToOne
	User_personnal_connexion user_personnal_connexion;
}
