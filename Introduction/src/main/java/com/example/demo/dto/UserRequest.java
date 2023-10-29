package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest {
	/**
	 * ユーザーID
	 */
	@NotEmpty(message = "UserIDは必須項目です。")
	@Size(max = 10, message = "UserIDは10文字以内で入力してください。")
	private String userId;
	/**
	 * メールアドレス
	 */
	@NotEmpty(message = "メールアドレスは必須項目です。")
	@Size(max = 100, message = "メールアドレスは正しい形式で入力してください。")
	private String email;
	/**
	 * パスワード
	 */
	@NotEmpty(message = "パスワードは必須項目です。")
	@Size(max = 10, message = "パスワードは10文字以内で入力してください。")
	private String password;
}
