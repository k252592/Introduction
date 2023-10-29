package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザーテーブル
 */
@Entity
@Data
@Table(name = "users", schema = "public")
public class UserEntity {

	/**
	 * ユーザーID
	 */
	@Id
	@Column(name = "user_id")
	private String userId;
	/**
	 * メールアドレス
	 */
	@Column(name = "email")
	private String email;
	/**
	 * パスワード
	 */
	@Column(name = "password")
	private String password;
	/*
	 * 登録日
	 */
	@Column(name = "created_at")
	private Date createDate;
}
