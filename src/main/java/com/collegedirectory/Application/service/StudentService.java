package com.collegedirectory.Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collegedirectory.Application.dao.DepartmentDao;
import com.collegedirectory.Application.dao.StudentDao;
import com.collegedirectory.Application.dao.UserDao;
import com.collegedirectory.Application.entity.Department;
import com.collegedirectory.Application.entity.Student;
import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.responseStructure.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao departmentDao;

	public ResponseEntity<?> saveStudent(Student student, long uid, long did) {

		Optional<User> uoptional = userDao.findById(uid);
		if (uoptional.isEmpty()) {
			throw new RuntimeException(" Invalid User Id " + uid);
		}

		Optional<Department> doptional = departmentDao.findById(did);
		if (doptional.isEmpty()) {
			throw new RuntimeException("Invalid Department id: " + did);
		}
		User user = uoptional.get();
		Department department = doptional.get();

		student.setUser(user);
		student.setDepartment(department);
		student.setName(user.getName());

		Student savestudent = studentDao.saveStudent(student);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Student profile saved successfully").body(savestudent).build();
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

	public ResponseEntity<?> findAllStudent() {

		List<Student> allStudents = studentDao.findAllStudents();
		if (allStudents.isEmpty()) {
			throw new RuntimeException("No Student Found");
		}
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("List of All Students").body(allStudents).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.FOUND).body(rs);
		return re;
	}

	public ResponseEntity<?> deleteStudent(long sid) {

		Optional<Student> optional = studentDao.findByID(sid);
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid Student id");
		}
		studentDao.deleteStudent(sid);
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Student deleted successfully").body(null).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

}
