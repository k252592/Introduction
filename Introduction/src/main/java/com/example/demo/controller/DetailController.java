package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController {

	@RequestMapping("/detail")
	public ModelAndView detail(ModelAndView mv) {
		mv.setViewName("detail");
		return mv;
	}
}
