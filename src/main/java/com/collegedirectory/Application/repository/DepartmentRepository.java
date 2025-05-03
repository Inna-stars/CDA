package com.collegedirectory.Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegedirectory.Application.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Optional<Department> findByName(String name);

}
