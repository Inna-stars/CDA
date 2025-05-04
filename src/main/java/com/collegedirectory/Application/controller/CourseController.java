package com.collegedirectory.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegedirectory.Application.entity.Course;
import com.collegedirectory.Application.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/{did}/{fid}")
	public ResponseEntity<?> saveCourse(@RequestBody Course course, long did, long fid){
		return courseService.saveCourse(course,did,fid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCourse(){
		return courseService.findAllCourse();
	}

}
