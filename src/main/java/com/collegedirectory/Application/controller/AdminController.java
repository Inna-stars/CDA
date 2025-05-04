package com.collegedirectory.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegedirectory.Application.entity.Admin;
import com.collegedirectory.Application.service.AdminService;

@RestController

@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/{uid}/{did}")
	public ResponseEntity<?> saveAdmin(@RequestBody Admin admin ,@PathVariable long uid, @PathVariable long did){
		return adminService.saveAdmin(admin, uid, did);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllAdmin(){
		return adminService.findAllAdmin();
	}
	
	
	
}
