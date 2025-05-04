package com.collegedirectory.Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegedirectory.Application.entity.Admin;
import com.collegedirectory.Application.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Optional<Admin> findById(long uid) {
		return adminRepository.findById(uid);
	}

	public List<Admin> findAllAdmin() {
		return adminRepository.findAll();
	}

}
