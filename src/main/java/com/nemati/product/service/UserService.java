package com.nemati.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemati.product.model.User;
import com.nemati.product.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		
		return user;
	}
	
	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}
}
