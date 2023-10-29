package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompleteController {

	@RequestMapping("/complete")
	public ModelAndView complete(ModelAndView mv) {
		mv.setViewName("complete");
		return mv;
	}
}
