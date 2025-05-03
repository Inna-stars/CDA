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

import com.collegedirectory.Application.entity.Student;
import com.collegedirectory.Application.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/{uid}/{did}")
	public ResponseEntity<?> saveStudent(@RequestBody Student student, @PathVariable long uid, @PathVariable long did){
		return studentService.saveStudent(student, uid, did);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllStudent(){
		return studentService.findAllStudent();
	}
	
	@DeleteMapping("/{sid}")
	public ResponseEntity<?> deleteStudent(@PathVariable long sid){
		return studentService.deleteStudent(sid);
	}
	
	
	
}
