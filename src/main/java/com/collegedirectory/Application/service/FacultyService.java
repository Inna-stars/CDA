package com.collegedirectory.Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collegedirectory.Application.dao.DepartmentDao;
import com.collegedirectory.Application.dao.FacultyDao;
import com.collegedirectory.Application.dao.UserDao;
import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.entity.Faculty;
import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.responseStructure.ResponseStructure;

@Service
public class FacultyService {

	@Autowired
	private FacultyDao facultyDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao departmentDao;

	public ResponseEntity<?> saveFaculty(Faculty faculty, long uid, long did) {

		Optional<Faculty> optional = facultyDao.findById(faculty.getUId());
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid User ID");
		}

		Optional<User> userOptional = userDao.findById(uid);
		if (userOptional.isEmpty()) {
			throw new RuntimeException("Invlid User id");
		}

		Optional<Department> deptOptional = departmentDao.findById(did);
		if (deptOptional.isEmpty()) {
			throw new RuntimeException("Invlid Department ID");
		}

		User user = userOptional.get();
		Department department = deptOptional.get();

		faculty.setUser(user);
		;
		faculty.setDepartment(department);
		faculty.setUsername(user.getUsername());

		Faculty saveFaculty = facultyDao.saveFaculty(faculty);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("faculty profile saved successfully").body(saveFaculty).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);
		return re;
	}

	public ResponseEntity<?> findAllFaculty() {

		List<Faculty> allFaculty = facultyDao.findAllFAculty();

		if (allFaculty.isEmpty()) {
			throw new RuntimeException("No Faculty Found");
		}

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value()).message("List of faculties")
				.body(allFaculty).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);
		
		return re;
	}

}
