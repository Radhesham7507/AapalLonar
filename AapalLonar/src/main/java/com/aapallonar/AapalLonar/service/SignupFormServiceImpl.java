package com.aapallonar.AapalLonar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aapallonar.AapalLonar.dao.SignupFormCurd;
import com.aapallonar.AapalLonar.model.SignupForm;

@Service
public class SignupFormServiceImpl implements SignupFormService {
	
	private SignupFormCurd signupFormCurd;
	
	@Autowired
	public void setSignupFormCurd(SignupFormCurd signupFormCurd) {
		this.signupFormCurd = signupFormCurd;
	}




	@Override
	public SignupForm saveSignupFormService(SignupForm signupForm) {
	
		
		return signupFormCurd.save(signupForm);
	}




	@Override
	public List<SignupForm> readAllSignupService() {
		
		return signupFormCurd.findAll();
	}

	@Override
	public void deleteSignup(String id) {
		
		signupFormCurd.deleteById(id);
		
		
	}

}
