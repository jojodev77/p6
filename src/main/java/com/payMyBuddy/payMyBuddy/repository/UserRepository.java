package com.payMyBuddy.payMyBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payMyBuddy.payMyBuddy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select u from User u  left join User_personnal_connexion b on u.user_personnal_informations.user_personnal_connexion.email=b.email WHERE b.email = :email")
	User findByEmail(@Param("email")String email);

}
