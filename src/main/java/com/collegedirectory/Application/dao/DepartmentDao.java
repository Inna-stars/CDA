package com.collegedirectory.Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.repository.DepartmentRepository;

@Repository
public class DepartmentDao {

	@Autowired
	private DepartmentRepository departmentRepository; 
	
	public Optional<Department> findById(long did) {
		return departmentRepository.findById(did);
	}

	public Optional<Department> findByName(String name) {
		return departmentRepository.findByName(name);
	}

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public void deleteDepartment(long did) {
		departmentRepository.deleteById(did);
	}

}
