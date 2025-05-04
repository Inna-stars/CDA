package com.collegedirectory.Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegedirectory.Application.entity.Student;
import com.collegedirectory.Application.repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> findAllStudents() {
		
		return studentRepository.findAll();
	}

	public Optional<Student> findByID(long sid) {
		return studentRepository.findById(sid);
	}

	public void deleteStudent(long sid) {
		studentRepository.deleteById(sid);
	}

}
