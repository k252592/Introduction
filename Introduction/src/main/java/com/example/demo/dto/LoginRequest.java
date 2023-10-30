package com.example.demo.dto;

import lombok.Data;

/**
 * ログイン画面からの入力条件を格納
 */
@Data
public class LoginRequest {

	private String userId;
	private String password;
	
}
