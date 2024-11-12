package com.aapallonar.AapalLonar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aapallonar.AapalLonar.model.HotelBookingForm;

public interface HotelBookingFormCurd extends MongoRepository<HotelBookingForm, String> {
	
	
	@Override
	public <S extends HotelBookingForm> S save(S entity);
	
	@Override
    public List<HotelBookingForm> findAll();
 
	
	@Override
	public void deleteById(String id) ;
}
