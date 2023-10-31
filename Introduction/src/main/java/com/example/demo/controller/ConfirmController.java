package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfirmController {
	
//	@Autowired
//	private InputRequest inputRequest;
	
	/**
	 * 確認画面の表示
	 * @param mv
	 * @return
	 */
	@RequestMapping("/user/input/confirm")
	public ModelAndView confirm(ModelAndView mv) {
		mv.setViewName("confirm");
		return mv;
	}
	
	/**
	 * 戻るボタンで入力画面の表示
	 */
	@RequestMapping("/user/input/back")
	public String inputShow() {
		return "input";
	}
	
//	public String create(@Validated @ModelAttribute InputrRequest inputRequest, BindingResult result, Model model) {
//		
//	}
}
