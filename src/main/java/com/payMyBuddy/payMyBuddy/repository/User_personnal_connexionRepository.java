package com.payMyBuddy.payMyBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.payMyBuddy.entity.User_personnal_connexion;

public interface User_personnal_connexionRepository extends JpaRepository<User_personnal_connexion, Long> {

	User_personnal_connexion findByEmail(String email);
}
