package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IntroductionsEntity;
import com.example.demo.repository.IntroductionsRepository;

@Service
public class DetailService {

	@Autowired
	private IntroductionsRepository repository;
	
	/**
	 * 自己紹介情報削除
	 */
	public void delete(String userId) {
		
		IntroductionsEntity introductions = repository.findByUserId(userId);
		repository.delete(introductions);
	}
	
}
