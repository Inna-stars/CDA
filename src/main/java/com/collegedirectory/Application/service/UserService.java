package com.collegedirectory.Application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collegedirectory.Application.dao.UserDao;
import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.responseStructure.ResponseStructure;
import com.collegedirectory.Application.util.UserStatus;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<?> saveUser(User user) {

		Optional<User> optional = userDao.findByEmail(user.getEmail());
		if (optional.isEmpty()) {
			ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
					.message("user email already has a registered account").body(null).build();

			ResponseEntity re = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);
			return re;
		}

		user.setStatus(UserStatus.INACTIVE);
		User saveuser = userDao.saveUser(user);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Saved Successfully").body(saveuser).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

}
