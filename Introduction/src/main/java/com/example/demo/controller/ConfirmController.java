package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfirmController {

	@RequestMapping("/confirm")
	public ModelAndView confirm(ModelAndView mv) {
		mv.setViewName("confirm");
		return mv;
	}
}
