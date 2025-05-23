package com.collegedirectory.Application.entity;

import com.collegedirectory.Application.util.Role;
import com.collegedirectory.Application.util.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String email;
	private String name;
	private long phone;
	private int otp;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private UserStatus status;
	
	@Enumerated(EnumType.STRING)
	private Role role;

}
