package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.InputRequest;

@Controller
public class InputController {

//	@Autowired
//	private InputService inputservice;
	
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
	
	@RequestMapping("/input/create")
	 public String create(@Validated @ModelAttribute InputRequest inputRequest, BindingResult result, Model model) {

		if(result.hasErrors()) {
			
			if(result.hasFieldErrors("name")) {
				// 
				FieldError name = result.getFieldError("name");
				model.addAttribute("nameError", name.getDefaultMessage());
			}
			
			if(result.hasFieldErrors("kana")) {
				// 
				FieldError kana = result.getFieldError("kana");
				model.addAttribute("kanaError", kana.getDefaultMessage());
			}
			if(result.hasFieldErrors("word")) {
				// 
				FieldError word = result.getFieldError("word");
				model.addAttribute("wordError", word.getDefaultMessage());
				
				return "input";
			}

			
			System.out.println(inputRequest.getName().toString());
		}
		
		return "confirm";
	 }
	
}
