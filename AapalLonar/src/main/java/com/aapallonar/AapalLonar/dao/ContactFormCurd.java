package com.aapallonar.AapalLonar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aapallonar.AapalLonar.model.ContactForm;

@Repository
public interface ContactFormCurd extends MongoRepository<ContactForm, String> {

	@Override
	public <S extends ContactForm> S save(S entity);
	
	
	@Override
	public List<ContactForm> findAll() ;
	
	@Override
	public void delete(ContactForm entity) ; 
	
	
}
