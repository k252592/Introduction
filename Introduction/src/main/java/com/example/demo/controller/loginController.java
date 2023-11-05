package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

	/**
	 * ログイン画面を表示
	 * @return ログイン画面
	 */
	@GetMapping("/login")
	public String view() {
		return "login";
	}

}