package com.collegedirectory.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegedirectory.Application.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
