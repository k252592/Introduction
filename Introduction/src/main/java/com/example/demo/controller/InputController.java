package com.example.demo.controller;



import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.InputRequest;

@Controller
public class InputController {

//	@Autowired
//	private InputService inputservice;
	
	/**
	 * 性別
	 */
	// ラジオボタンのマップ作成
	public Map<String,String> radioGender;
	
	// 初期化用のメソッドを作成しラジオボタンを格納
	private Map<String, String> initRadioGender() {
        Map<String, String> radio = new LinkedHashMap<>();
        radio.put("0", "男性");
        radio.put("1", "女性");
        return radio;
	}
	
	/**
	 * 入力画面を表示
	 * @return
	 */
	@GetMapping("/input")
	public String display(Model model) {
		// ラジオボタン格納メソッドの戻り値をマップに格納し、モデルにセット
		radioGender = initRadioGender();
        model.addAttribute("radioGender", radioGender);
		
		model.addAttribute("inputRequest", new InputRequest());
		return "input";
	}
	
	/**
	 * TOP画面へ戻る
	 */
	@RequestMapping("/top")
	public String back() {
		return "top";
	}
	
//	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/input/create")
	 public String create(@Validated @ModelAttribute InputRequest inputRequest, BindingResult result, Model model) {

		if(result.hasErrors()) {
			// エラーが発生した場合
			if(result.hasFieldErrors("name")) {
			FieldError name = result.getFieldError("name");
			model.addAttribute("nameError", name.getDefaultMessage());
			}
			
			if(result.hasFieldErrors("kana")) {
			FieldError kana = result.getFieldError("kana");
			model.addAttribute("kanaError", kana.getDefaultMessage());
			}
			
			if(result.hasFieldErrors("word")) {
				
				FieldError word = result.getFieldError("word");
				model.addAttribute("wordError", word.getDefaultMessage());
			}
//			System.out.println(inputRequest.getName().toString());
//			System.out.println(result);
			 model.addAttribute("radioGender", radioGender);
				
			return "input";
			
		}
		
		model.addAttribute("name", inputRequest.getName().toString());
		model.addAttribute("kana", inputRequest.getKana().toString());
		model.addAttribute("gender",inputRequest.getGender());
		model.addAttribute("word", inputRequest.getWord().toString());
//		System.out.println(radioGender.get("0"));
		
		return "confirm";
	 }
	
}
