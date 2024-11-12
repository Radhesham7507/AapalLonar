package com.aapallonar.AapalLonar.dao;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.aapallonar.AapalLonar.model.SignupForm;

public interface SignupFormCurd extends MongoRepository<SignupForm,String> {

	
	
	
	@Override
	public <S extends SignupForm> S save(S entity) ;

	@Override
	public List<SignupForm> findAll() ;
	
	@Override
	public void delete(SignupForm entity);
}
