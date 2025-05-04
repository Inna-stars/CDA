package com.collegedirectory.Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegedirectory.Application.entity.Admin;
import com.collegedirectory.Application.entity.Course;
import com.collegedirectory.Application.repository.CourseRepository;

@Repository
public class CourseDao {
	
	@Autowired
	private CourseRepository courseRepository;

	public Optional<Course> findById(long id) {
		return courseRepository.findById(id);
	}

	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> findAllCourse() {
		return courseRepository.findAll();
	}

}
