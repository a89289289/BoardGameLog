package com.example.psi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psi.entity.User;
import com.example.psi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepository;

	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }
}
