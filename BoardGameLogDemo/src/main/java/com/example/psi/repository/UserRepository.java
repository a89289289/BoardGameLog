package com.example.psi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.psi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}