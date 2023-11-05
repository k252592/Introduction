package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * 新規登録
	 * パスワードはハッシュ化して格納 
	 */
	public String create(UserRequest userRequest, Model model) {
		
		// ユーザー登録があるかどうか判定
		if(userRepository.existsByUserId(userRequest.getUserId())) {
			model.addAttribute("existsUserId", "このユーザーは登録済みです。");
			return "register";
		}else {
			// 新規登録処理
			Date now = new Date();
			UserEntity user = new UserEntity();
			user.setUserId(userRequest.getUserId());
			user.setEmail(userRequest.getEmail());
			user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
			user.setCreateDate(now);
			
			userRepository.saveAndFlush(user);
			model.addAttribute("register", "ユーザ登録が完了しました。");
			return "redirect:/register";
		}
	}
}
