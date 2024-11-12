package com.aapallonar.AapalLonar.service;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aapallonar.AapalLonar.dao.GalleryFormCurd;
import com.aapallonar.AapalLonar.model.GalleryImageForm;

@Service
public class GalleryFormServiceImpl implements GalleryFormService {
	
	public GalleryFormCurd galleryFormCurd;
	
    @Autowired
	public void setGalleryFormCurd(GalleryFormCurd galleryFormCurd) {
		this.galleryFormCurd = galleryFormCurd;
	}


    @Transactional(rollbackFor=Exception.class)
	@Override
	public GalleryImageForm addphoto(GalleryImageForm galleryImageForm, MultipartFile multipartFile) throws Exception {
		GalleryImageForm save=null;
		try {
			
			save=galleryFormCurd.save(galleryImageForm);
			
			if(save!=null)
			{
				String path="/home/radhesham/Desktop/Finalproject/AapalLonar/src/main/resources/static/image"+multipartFile.getOriginalFilename();
				
				byte[] bytes=multipartFile.getBytes();
				
				FileOutputStream fos=new FileOutputStream(path);
				fos.write(bytes);
			}
			
		} catch (Exception e) {
			save=null;
			throw e;
		}
		return save;
	}


	@Override
	public List<GalleryImageForm> getAllPhotos() {
		
		return galleryFormCurd.findAll();
	}


	@Override
	public List<GalleryImageForm> readAllPhotos() {
		
		return galleryFormCurd.findAll();
	}


	@Override
	public void deletephoto(String id) {
		galleryFormCurd.deleteById(id);
		
	}

}
