package com.aapallonar.AapalLonar.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aapallonar.AapalLonar.model.LoginForm;

public interface LoginUserDao extends MongoRepository<LoginForm,String> {
	
	Optional<LoginForm> findByUsername(String username); 

}
