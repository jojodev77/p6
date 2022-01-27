package com.payMyBuddy.payMyBuddy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.payMyBuddy.entity.ERole;
import com.payMyBuddy.payMyBuddy.entity.User_role;

public interface User_roleRepository extends JpaRepository<User_role, Long> {

	static Optional<User_role> findByName(ERole r) {
		// TODO Auto-generated method stub
		return null;
	}

	static Optional<User_role> findByName(User_role r) {
		// TODO Auto-generated method stub
		return null;
	}

}
