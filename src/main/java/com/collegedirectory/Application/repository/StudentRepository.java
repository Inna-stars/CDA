package com.collegedirectory.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegedirectory.Application.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
