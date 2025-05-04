package com.collegedirectory.Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegedirectory.Application.entity.Faculty;
import com.collegedirectory.Application.repository.FacultyRepository;

@Repository
public class FacultyDao {

	@Autowired
	private FacultyRepository facultyRepository;
	
	public Optional<Faculty> findById(long uId) {
		return facultyRepository.findById(uId);
	}

	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	public List<Faculty> findAllFAculty() {
		
		return facultyRepository.findAll();
	}

}
