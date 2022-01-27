package com.payMyBuddy.payMyBuddy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User_role implements Serializable {
	public  User_role(Object object, ERole roleAdmin) {
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private ERole name;

	
}
