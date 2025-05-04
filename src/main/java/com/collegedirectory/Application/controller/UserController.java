package com.collegedirectory.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegedirectory.Application.dto.Userdto;
import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/{uid}")
	public ResponseEntity<?> deleteUserById(@PathVariable long uid){
		return userService.deleteUserById(uid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody Userdto dto){
		return userService.updateUser(dto);
	}
}
