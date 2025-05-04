package com.collegedirectory.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegedirectory.Application.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
