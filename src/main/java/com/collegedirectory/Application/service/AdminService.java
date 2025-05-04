package com.collegedirectory.Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collegedirectory.Application.dao.AdminDao;
import com.collegedirectory.Application.dao.DepartmentDao;
import com.collegedirectory.Application.dao.UserDao;
import com.collegedirectory.Application.entity.Admin;
import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.responseStructure.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao departmentDao;

	public ResponseEntity<?> saveAdmin(Admin admin, long uid, long did) {

		Optional<Admin> adoptional = adminDao.findById(uid);
		if (adoptional.isPresent()) {
			throw new RuntimeException("User already Existing");
		}
		Optional<User> byId = userDao.findById(uid);
		if (byId.isEmpty()) {
			throw new RuntimeException("Invalid User ID");
		}
		Optional<Department> byId2 = departmentDao.findById(did);
		if (byId2.isEmpty()) {
			throw new RuntimeException("Invalid Department ID");
		}

		User user = byId.get();
		Department department = byId2.get();
		admin.setUser(user);
		admin.setDepartment(department);
		admin.setUsername(user.getUsername());

		Admin saveAdmin = adminDao.saveAdmin(admin);
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Admin profile setup successfully").body(saveAdmin).build();
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

	public ResponseEntity<?> findAllAdmin() {

		List<Admin> allAdmin = adminDao.findAllAdmin();
		if (allAdmin.isEmpty()) {
			throw new RuntimeException("NO Admin Found");
		}

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("List of All Admins").body(allAdmin).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.FOUND).body(rs);
		return re;
	}

}
