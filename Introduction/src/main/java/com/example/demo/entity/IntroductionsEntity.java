package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 自己紹介テーブル
 */
@Entity
@Data
@Table(name = "introductions", schema = "public")
public class IntroductionsEntity {

	/**
	 * 自己紹介ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "introduction_id")
	private Integer introduction_id;
	/**
	 * ユーザーID
	 */
	@Column(name = "user_id")
	private String userId;
	/**
	 * 氏名
	 */
	@Column(name = "name")
	private String name;
	/**
	 * フリガナ
	 */
	@Column(name = "kana")
	private String kana;
	/**
	 * 性別
	 */
	@Column(name = "gender")
	private char gender;
	/**
	 * 趣味
	 */
	@Column(name = "hobby")
	private String hobby;
	/**
	 * 一言
	 */
	@Column(name = "word")
	private String word;
	/*
	 * 登録日
	 */
	@Column(name = "created_at")
	private Date createDate;
	/*
	 * 更新日
	 */
	@Column(name = "updated_at")
	private Date updateDate;
}
