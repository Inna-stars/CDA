package com.collegedirectory.Application.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(long uid) {
		userRepository.deleteById(uid);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
