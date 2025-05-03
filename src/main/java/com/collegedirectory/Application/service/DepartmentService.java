package com.collegedirectory.Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.collegedirectory.Application.dao.DepartmentDao;
import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.responseStructure.ResponseStructure;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	public ResponseEntity<?> saveDepartment(Department department) {

		Optional<Department> optional = departmentDao.findByName(department.getName());
		if (optional.isPresent()) {
			throw new RuntimeException("Department already Exist");
		}

		Department saveDepartment = departmentDao.saveDepartment(department);
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.CREATED.value())
				.message("department created successfully").body(saveDepartment).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.CREATED).body(rs);
		return re;
	}

	public ResponseEntity<?> fetchAllDepartment() {

		List<Department> allDepartments = departmentDao.findAll();
		if (allDepartments.isEmpty()) {
			throw new RuntimeException("No Departments Found ");
		}
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("List of All Departments").body(allDepartments).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.FOUND).body(rs);

		return re;
	}

	public ResponseEntity<?> deleteDepartment(long did) {

		Optional<Department> byId = departmentDao.findById(did);
		if (byId.isEmpty()) {
			throw new RuntimeException("Invalid Department Id: " + did);
		}

		departmentDao.deleteDepartment(did);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department delete successfully").body(null).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

}
