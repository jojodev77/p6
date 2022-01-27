package com.payMyBuddy.payMyBuddy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.payMyBuddy.payMyBuddy.dto.User_personnal_connexion_DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorColumn(name = "type")
@Table(name = "user_personnal_connexion", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "email") 
	})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_personnal_connexion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@OneToOne
	User_personnal_informations user_personnal_informations;
	
	String email;
	
	String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	List<User_role> user_role= new ArrayList<>();


	
	
}
