package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.InputRequest;
import com.example.demo.service.InputService;

@Controller
public class ConfirmController {
	
	@Autowired
	InputService inputService;
	
	/**
	 * 確認画面の表示
	 * @param mv
	 * @return
	 */
	@RequestMapping("/confirm")
	public Model confirm(Model model) {
		model.addAttribute("confirm");
		return model;
	}
	
	/**
	 * 戻るボタンで入力画面の表示
	 */
	@RequestMapping("/user/back")
	public String back(
			@RequestParam("name")String name, 
			@RequestParam("kana")String kana,
			@RequestParam("gender")String gender,
			@RequestParam("hobby")String hobby,
			@RequestParam("word")String word,
			@ModelAttribute InputRequest inputRequest, Model model
			) {
		
		model.addAttribute("radioGender", inputService.radioGender());
        model.addAttribute("checkHobby", inputService.checkHobby());
		model.addAttribute("inputRequest", new InputRequest());
		
		List<String> hobbyList = Arrays.asList(hobby.split(","));
		
		model.addAttribute("nameRecord", name);
		model.addAttribute("kanaRecord", kana);
		model.addAttribute("genderRecord", gender);
		model.addAttribute("hobbyRecord", hobbyList);
		model.addAttribute("wordRecord", word);
		
		return "input";
	}
	
	/**
	 * 完了ボタン押下時の処理
	 */
	@RequestMapping("/user/complete")
	public String complete(
			@RequestParam("name")String name,
			@RequestParam("kana")String kana,
			@RequestParam("gender")String gender,
			@RequestParam("hobby")String hobby,
			@RequestParam("word")String word,
			@ModelAttribute InputRequest inputRequest
			) {
		
		inputService.input(name, kana, gender, hobby, word);
		
		return "top";
	}
	
}
