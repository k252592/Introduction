package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	/**
	 * 
	 * SQL(Select * From users Where userId = ?)と同じ
	 * @param userId 
	 * userId に一致するレコードの取得
	 * @return
	 */
	UserEntity findByUserId(String userId);
	boolean existsByUserId(String userId);

}
