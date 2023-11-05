package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IntroductionsEntity;

@Repository
public interface IntroductionsRepository extends JpaRepository<IntroductionsEntity, String>{

	IntroductionsEntity findByUserId(String userId) ;
	
	boolean existsByUserId(String userId);
}
