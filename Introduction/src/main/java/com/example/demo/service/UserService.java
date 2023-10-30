package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * 登録 Repository
	 */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * PasswordEncoder
	 */
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * 新規登録
	 * パスワードはハッシュ化して格納 
	 */
	public void create(UserRequest userRequest) {
		Date now = new Date();
		UserEntity user = new UserEntity();
		user.setUserId(userRequest.getUserId());
		user.setEmail(userRequest.getEmail());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setCreateDate(now);
		userRepository.saveAndFlush(user);
	}

}
