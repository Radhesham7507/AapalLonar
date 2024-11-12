package com.aapallonar.AapalLonar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aapallonar.AapalLonar.model.GalleryImageForm;

public interface GalleryFormCurd extends MongoRepository<GalleryImageForm, String> {
	
	@Override
	public <S extends GalleryImageForm> S save(S entity);
 
	@Override
	public List<GalleryImageForm> findAll();
	
	
	@Override
	public void delete(GalleryImageForm entity);
}
