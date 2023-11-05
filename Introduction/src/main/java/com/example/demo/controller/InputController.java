package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.SecuritySession;
import com.example.demo.dto.InputRequest;
import com.example.demo.entity.IntroductionsEntity;
import com.example.demo.repository.IntroductionsRepository;
import com.example.demo.service.InputService;

@Controller
public class InputController {
	
	@Autowired
	InputService inputService;
	
	@Autowired
    private SecuritySession securitySession;
	
	@Autowired
	private IntroductionsRepository repository;

	/**
	 * 登録済みユーザー情報の表示
	 * @param model
	 * @return
	 */
	public String input(Model model) {
		// DBからユーザーのレコードを検索し画面へ
		IntroductionsEntity userRecord = repository.findByUserId(securitySession.getUsername());
		
		List<String> hobbyRecord = Arrays.asList(userRecord.getHobby().split(","));
		
		model.addAttribute("nameRecord", userRecord.getName());
		model.addAttribute("kanaRecord", userRecord.getKana());
		model.addAttribute("genderRecord", userRecord.getGender());
		model.addAttribute("hobbyRecord", hobbyRecord);
		model.addAttribute("wordRecord", userRecord.getWord());
		
		return "input";
	}
	
	/**
	 * 登録/更新押下時の処理（入力画面を表示）
	 * @return
	 * 性別、趣味をモデルに格納
	 */
	@RequestMapping("/user/input")
	public String display(InputRequest inputRequest, Model model) {
		
        model.addAttribute("radioGender", inputService.radioGender());
        model.addAttribute("checkHobby", inputService.checkHobby());
		model.addAttribute("inputRequest", new InputRequest());
		
		if(repository.existsByUserId(securitySession.getUsername())) {
			
			return input(model);
			
		}else {
			
			return "input";
		}
	}
	
	/**
	 * TOP画面へ戻る
	 */
	@RequestMapping("/top")
	public String back() {
		return "top";
	}
	
	/**
	 * 自己紹介登録ボタン押下時の処理
	 * @param inputRequest
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/input/create")
	 public String create(@Validated @ModelAttribute InputRequest inputRequest, BindingResult result, Model model) {

		/**
		 * エラーが発生した場合
		 */
		if(result.hasErrors()) {
			// 名前に対するエラー
			if(result.hasFieldErrors("name")) {
			FieldError name = result.getFieldError("name");
			model.addAttribute("nameError", name.getDefaultMessage());
			}
			// フリガナに対するエラー
			if(result.hasFieldErrors("kana")) {
			FieldError kana = result.getFieldError("kana");
			model.addAttribute("kanaError", kana.getDefaultMessage());
			}
			// 趣味に対するエラー
			if(result.hasFieldErrors("hobby")) {
				FieldError kana = result.getFieldError("hobby");
				model.addAttribute("hobbyError", kana.getDefaultMessage());
				}
			// 一言に対するエラー
			if(result.hasFieldErrors("word")) {
				FieldError word = result.getFieldError("word");
				model.addAttribute("wordError", word.getDefaultMessage());
			}
			 model.addAttribute("radioGender", inputService.radioGender());
			 model.addAttribute("checkHobby", inputService.checkHobby());
				
			return "input";
			
		}

		/**
		 * 入力情報をモデルに格納
		 */
		model.addAttribute("name", inputRequest.getName().toString());
		model.addAttribute("kana", inputRequest.getKana().toString());
		model.addAttribute("genderValue", inputRequest.getGender());
		model.addAttribute("hobbyValue", inputRequest.getHobby());
		model.addAttribute("word", inputRequest.getWord().toString());
		
		return "confirm";
	 }
	
}
