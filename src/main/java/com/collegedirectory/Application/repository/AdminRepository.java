package com.collegedirectory.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegedirectory.Application.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
