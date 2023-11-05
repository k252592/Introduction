package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
	
	/**
	 * TOP画面の表示
	 * @param mv
	 * @return
	 */
	@GetMapping("/top")
	public String view() {
		return "top";
	}
	
}
