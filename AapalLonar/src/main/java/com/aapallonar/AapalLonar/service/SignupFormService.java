package com.aapallonar.AapalLonar.service;

import java.util.List;

import com.aapallonar.AapalLonar.model.SignupForm;

public interface SignupFormService {

	
	
public SignupForm saveSignupFormService(SignupForm signupForm);

public List<SignupForm> readAllSignupService();

public void deleteSignup(String id);


}
