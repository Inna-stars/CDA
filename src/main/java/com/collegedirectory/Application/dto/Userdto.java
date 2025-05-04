package com.collegedirectory.Application.dto;

import lombok.Data;

@Data
public class Userdto {
	
	private long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private long phone;

}
