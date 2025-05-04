package com.collegedirectory.Application.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collegedirectory.Application.dao.UserDao;
import com.collegedirectory.Application.dto.Userdto;
import com.collegedirectory.Application.entity.User;
import com.collegedirectory.Application.responseStructure.ResponseStructure;
import com.collegedirectory.Application.util.UserStatus;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<?> saveUser(User user) {

		Optional<User> optional = userDao.findByEmail(user.getEmail());
		if (optional.isPresent()) {
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

	public ResponseEntity<?> deleteUserById(long uid) {

		Optional<User> byId = userDao.findById(uid);
		if (byId.isEmpty()) {
			ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
					.message("Invalid user id: " + uid).body(null).build();

			ResponseEntity re = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);
			return re;
		}

		userDao.deleteUserById(uid);
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User delete successfuly (deleted usr id " + uid + ")").body(null).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

	public ResponseEntity<?> findAllUsers() {

		List<User> allusers = userDao.findAllUsers();

		if (allusers.isEmpty()) {
			ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
					.message("No users found").body(null).build();

			ResponseEntity re = ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
			return re;
		}

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("List of All users")
				.body(allusers).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.FOUND).body(rs);

		return re;
	}

	public ResponseEntity<?> updateUser(Userdto dto) {

		Optional<User> byId = userDao.findById(dto.getId());
		if (byId.isEmpty()) {
			throw new RuntimeException("Invalid user id");
		}
		User user = byId.get();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPassword(dto.getPassword());
		user.setPhone(dto.getPhone());
		user.setStatus(UserStatus.ACTIVE);
		
		User saveUser = userDao.saveUser(user);

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("user updated successfully").body(saveUser).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.OK).body(rs);

		return re;
	}

}
