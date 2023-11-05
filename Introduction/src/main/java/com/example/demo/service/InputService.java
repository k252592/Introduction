package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.SecuritySession;
import com.example.demo.entity.IntroductionsEntity;
import com.example.demo.repository.IntroductionsRepository;

@Service
public class InputService {
	
	@Autowired
	private IntroductionsRepository repository;
	
	@Autowired
    private SecuritySession securitySession;
		
	/**
	 * 性別のラジオボタン作成
	 */
	public List<String> radioGender() {
        List<String> radio = new ArrayList<String>();
        radio.add("男性");
        radio.add("女性");
        return radio;
	}
	
	
	public List<String> checkHobby(){
		List<String> check = new ArrayList<String>();
		check.add("映画");
		check.add("スポーツ");
		check.add("音楽");
		check.add("読書");
		check.add("料理");
		check.add("旅行");
		return check;
	}
	
	/**
	 * 自己紹介情報登録
	 * @param name 
	 * @param kana 
	 * @param gender 
	 * @param hobby 
	 * @param word 
	 */
	public void input(String name, String kana, String gender, String hobby, String word) {
		
		Date now = new Date();
		IntroductionsEntity introductions = new IntroductionsEntity();
			
			introductions.setUserId(securitySession.getUsername());
			introductions.setName(name);
			introductions.setKana(kana);
			introductions.setGender(gender);
			introductions.setHobby(hobby);
			introductions.setWord(word);
			introductions.setUpdateDate(now);
		
		repository.saveAndFlush(introductions);
	}

}
