package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 自己紹介登録情報
 */
@Data
public class InputRequest {
	
	/**
	 * 名前
	 */
	@NotEmpty(message = "名前は必須項目です。")
	@Size(max = 10, message = "名前は10文字以内で入力してください。")
	private String name;
	
	/**
	 * フリガナ
	 */
	@NotEmpty(message = "フリガナは必須項目です。")
	@Size(max = 20, message = "フリガナは20文字以内で入力してください。")
	private String kana;
	
	/**
	 * 性別
	 */
	private char gender;
	
	/**
	 * 趣味
	 */
	private String hobby;
	
	/**
	 * 一言
	 */
	@Size(max = 300, message = "一言は300文字以内で入力してください。")
	private String word;

}
