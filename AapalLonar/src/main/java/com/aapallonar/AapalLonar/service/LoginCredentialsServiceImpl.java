package com.aapallonar.AapalLonar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aapallonar.AapalLonar.dao.LoginUserDao;
import com.aapallonar.AapalLonar.model.LoginForm;

@Service
public class LoginCredentialsServiceImpl implements LoginCredentialsService {
	
	
	private LoginUserDao loginUserDao;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setLoginUserDao(LoginUserDao loginUserDao) {
		this.loginUserDao = loginUserDao;
	}


    @Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}



	@Override
	public String checkUserCredentials(String oldusername, String oldpassword) {
		
		Optional<LoginForm> byUsername= loginUserDao.findByUsername(oldusername);
		
		if(byUsername.isPresent())
		{
			LoginForm loginform=byUsername.get();
			Boolean matches=passwordEncoder.matches(oldpassword, loginform.getPassword());
			
			if(matches)
			{
				return "SUCCESS";
			}
			else
			{
				return "Maybe Your  Username or password is Worng please Check it!";
			}
		}
		else
		{
			return "Maybe Your  Username or password is Worng please Check it!";

		}
		
		
	}

}
