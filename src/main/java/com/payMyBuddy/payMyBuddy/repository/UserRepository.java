package com.payMyBuddy.payMyBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payMyBuddy.payMyBuddy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
