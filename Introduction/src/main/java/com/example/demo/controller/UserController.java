package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 新規会員登録画面を表示
	 * @param model モデル
	 * @return 新規会員登録画面
	 */
	@GetMapping("/register")
	public String view(Model model) { 
		model.addAttribute("userRequest", new UserRequest());
		return "register";
	}
	
	/**
	 * 新規会員登録
	 * @param
	 * 
	 */
	@RequestMapping("/user/create")
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		// 入力エラー
		if(result.hasErrors()) {
			if(result.hasFieldErrors("userId")) {
				// ユーザーIDにエラーがある場合
				FieldError userId = result.getFieldError("userId");
				model.addAttribute("userIdError", userId.getDefaultMessage());
			}
			if(result.hasFieldErrors("email")) {
				// メールアドレスにエラーがある場合
				FieldError email = result.getFieldError("email");
				model.addAttribute("EmailError", email.getDefaultMessage());
			}
			if(result.hasFieldErrors("password")) {
				// パスワードにエラーがある場合
				FieldError password = result.getFieldError("password");
				model.addAttribute("PasswordError", password.getDefaultMessage());
			}
			return "register";
		}else{
			return userService.create(userRequest, model);
		}
		
	}
	
}
