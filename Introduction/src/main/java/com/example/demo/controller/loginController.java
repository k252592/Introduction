package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class loginController {

	@GetMapping("/login")
	public String show() {
		return "login";
	}
	
	/**
	 * PasswordEncoder
	 */
//	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
//	@GetMapping
//	public String loginShow() {
//		return "top";
//	}
//	@RequestMapping("/user/login")
//	public String login(LoginRequest userId, LoginRequest password) {
//		
//		
//		
//		
//		// 入力された値の条件判定
//		
////		if(userId.getUserId().equals("yama3") && password.getPassword().equals("123456")) {
////			return "top";
////		}else {
////			return "top";
////		}
//		return "/top";
//		
		
//	}
	
	/**
	 * 条件分岐を作成
	 * DBから検索→ID.PASが一致したらtopへ
	 * 不一致の場合ログイン画面を返す
	 */
}