package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IntroductionsEntity;
import com.example.demo.repository.IntroductionsRepository;

@Service
public class ListService {

	@Autowired
//	UsersRepository usersRepository;
	IntroductionsRepository introductionsRepository;
	
	public List<IntroductionsEntity> searchAll(){
		return introductionsRepository.findAll();
	}
}
