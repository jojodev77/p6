package com.payMyBuddy.payMyBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;
import com.payMyBuddy.payMyBuddy.entity.User_personnal_informations;

public interface User_personnal_informationsRepository extends JpaRepository<User_personnal_informations, Long>{

	@Query("select u from User_personnal_informations u WHERE u.user_personnal_connexion = :upc ")
	User_personnal_informations findByUserPersonnalConnexionById(@Param("upc") User_personnal_connexion upc);

}
