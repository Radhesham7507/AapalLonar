package com.aapallonar.AapalLonar.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aapallonar.AapalLonar.model.GalleryImageForm;

public interface GalleryFormService {
	
	public GalleryImageForm  addphoto(GalleryImageForm galleryImageForm,MultipartFile multipartFile) throws Exception;
	
	List<GalleryImageForm> getAllPhotos();
 
	public List<GalleryImageForm> readAllPhotos();
	
	public void deletephoto(String id);
}
