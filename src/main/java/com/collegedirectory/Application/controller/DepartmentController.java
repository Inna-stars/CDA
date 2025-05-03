package com.collegedirectory.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department){
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping
	public ResponseEntity<?> fetchAllDept(){
		return departmentService.fetchAllDepartment();
	}
	
	@DeleteMapping("/{did}")
	public ResponseEntity<?> deleteDepartment(@PathVariable long did){
		return departmentService.deleteDepartment(did);
	}
	
	

}
