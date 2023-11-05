package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.IntroductionsEntity;
import com.example.demo.service.ListService;

@Controller
public class ListController {

	/**
	 * 一覧画面
	 */
	@Autowired
	ListService listService;
	
	/**
	 * 一覧画面を表示
	 * @param model Model
	 * @return 一覧画面表示
	 */
	@RequestMapping("/user/list")
	public String displayList(Model model) {
		List<IntroductionsEntity> userlist = listService.searchAll();
		model.addAttribute("userlist", userlist);
		return "list";
	}
}
