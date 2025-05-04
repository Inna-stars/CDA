package com.collegedirectory.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collegedirectory.Application.entity.Faculty;
import com.collegedirectory.Application.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@PostMapping("/{uid}/{did}")
	public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty, @PathVariable long uid, @PathVariable long did){
		return facultyService.saveFaculty(faculty, uid, did);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllFaculty(){
		return facultyService.findAllFaculty();
	}
	
	
}
