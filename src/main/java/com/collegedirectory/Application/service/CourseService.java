package com.collegedirectory.Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collegedirectory.Application.dao.CourseDao;
import com.collegedirectory.Application.dao.DepartmentDao;
import com.collegedirectory.Application.dao.FacultyDao;
import com.collegedirectory.Application.entity.Course;
import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.entity.Faculty;
import com.collegedirectory.Application.responseStructure.ResponseStructure;

@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private FacultyDao facultyDao;
	

	public ResponseEntity<?> saveCourse(Course course, long did, long fid) {
		
		Optional<Course> optional = courseDao.findById(course.getId());
		if(optional.isPresent()) {
			throw new RuntimeException("Course already exist");
		}
		
		Optional<Department> byId = departmentDao.findById(did);
		if(byId.isEmpty()) {
			throw new RuntimeException("Invalid Department ID");
		}
		Optional<Faculty> byId2 = facultyDao.findById(fid);
		if(byId2.isEmpty()) {
			throw new RuntimeException("Invalid Faculty ID");
		}
		
		Department department = byId.get();
		Faculty faculty = byId2.get();
		
		course.setDepartment(department);
		course.setFaculty(faculty);
		
		Course savecourse = courseDao.saveCourse(course);
		
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Course added successfully").body(savecourse).build();
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}


	public ResponseEntity<?> findAllCourse() {
		List<Course> allCourse = courseDao.findAllCourse();
		if (allCourse.isEmpty()) {
			throw new RuntimeException("NO Course Found");
		}

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("List of All Courses").body(allCourse).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.FOUND).body(rs);
		return re;
	
	}	
	
}














