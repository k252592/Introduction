package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {

	/**
	 * 入力画面を表示
	 * @return
	 */
	@RequestMapping("/user/input")
	public String show() {
		return "input";
	}
	
	/**
	 * TOP画面へ戻る
	 */
	@RequestMapping("/top")
	public String back() {
		return "top";
	}
	
	/**
	 * 自己紹介情報の登録
	 */
	
	@RequestMapping("/user/confirm")
	public String confirm(@RequestParam("name")String name, @RequestParam("kana")String kana, Model model) {
		
		model.addAttribute("name", name);
		System.out.println(name);
		model.addAttribute("kana",kana);
		
		return "confirm";
	}
	
}
