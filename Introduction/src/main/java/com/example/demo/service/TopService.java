package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.SecuritySession;
import com.example.demo.repository.IntroductionsRepository;

@Service
public class TopService {

	@Autowired
	private IntroductionsRepository introductionsRepository;
	
	@Autowired
    private SecuritySession securitySession;
	
	/**
	 * ログインユーザーの登録情報を検索
	 * @return
	 */
//	public List getById() {
//		System.out.println(introductionsRepository.findAllByUserId(securitySession.getUsername()));
//		return introductionsRepository.findAllByUserId(securitySession.getUsername());
//	}
	
}
