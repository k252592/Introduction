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
	 * @param model Model
	 * @return 
	 */
	@GetMapping("/register")
	public String displayRegister(Model model) {
		// 
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
		
		if(result.hasErrors()) {
			if(result.hasFieldErrors("userId")) {
				// 
				FieldError userId = result.getFieldError("userId");
				model.addAttribute("userIdError", userId.getDefaultMessage());
			}
			
			if(result.hasFieldErrors("email")) {
				// 
				FieldError email = result.getFieldError("email");
				model.addAttribute("EmailError", email.getDefaultMessage());
			}
			if(result.hasFieldErrors("email")) {
				// 
				FieldError password = result.getFieldError("password");
				model.addAttribute("PasswordError", password.getDefaultMessage());
			}
			return "register";
		}
		
		// ユーザー情報登録
		userService.create(userRequest);
		return "redirect:/register";
		
	}
	
}
