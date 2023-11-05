package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.config.SecuritySession;
import com.example.demo.dto.InputRequest;
import com.example.demo.entity.IntroductionsEntity;
import com.example.demo.repository.IntroductionsRepository;
import com.example.demo.service.DetailService;
import com.example.demo.service.InputService;

@Controller
public class DetailController {

	@Autowired
	IntroductionsRepository repository;
	
	@Autowired
    private SecuritySession securitySession;
	
	@Autowired
	DetailService detailService;
	
	@Autowired
	InputService inputService;
	
	@Autowired
	ListController listController;
	
	@Autowired
	InputController inputController;
	
	@RequestMapping("/detail")
	public String view(@RequestParam(value = "*{userId}") String userId, Model model) {
		
		/**
		 * 選択したIDのレコードを検索
		 * 詳細画面へ遷移
		 */
		IntroductionsEntity userDetail = repository.findByUserId(userId);
		model.addAttribute("userDetail", userDetail);
		
		return "detail";
	}
	
	/**
	 * 詳細画面からの遷移
	 */
	@RequestMapping("/detail/action")
	public String detail(@RequestParam("action")String action, @RequestParam("userId")String userId, Model model) {
		
		
		System.out.println(userId);
		// 一覧画面に戻る
		if(action.equals("戻る")) {
			
			return listController.displayList(model);
		}
		
		// 編集処理
		if(action.equals("編集")) {
			
			if(userId.equals(securitySession.getUsername())) {
				// 情報を保持した入力画面へ
				
				model.addAttribute("radioGender", inputService.radioGender());
		        model.addAttribute("checkHobby", inputService.checkHobby());
				model.addAttribute("inputRequest", new InputRequest());
				
				return inputController.input(model);
				
			}else {
				// 編集エラーを表示
				model.addAttribute("detailMsg", "編集権限がありません。");
				return view(userId, model);
			}
		}
		
		// 削除処理
		if(action.equals("削除")) {
			
			// ログインユーザーかどうか判定
			if(userId.equals(securitySession.getUsername())) {
				// 削除処理 + 削除完了画面へ
				detailService.delete(userId);
				return "deleteFin";
			}else {
				// 削除エラーを表示
				model.addAttribute("detailMsg", "削除権限がありません。");
				
				return view(userId, model);
			}
		}
		return null;
	}
	
}
