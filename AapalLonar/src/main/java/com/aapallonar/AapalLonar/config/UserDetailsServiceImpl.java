package com.aapallonar.AapalLonar.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aapallonar.AapalLonar.dao.LoginUserDao;
import com.aapallonar.AapalLonar.model.LoginForm;

import jakarta.annotation.PostConstruct;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
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
	
	@PostConstruct
	public void init()
	{
		long count=loginUserDao.count();
		if(count==0)
		{
			LoginForm loginform=new LoginForm();
			
			loginform.setUsername("radhe");
			loginform.setPassword(passwordEncoder.encode("radhe123"));
			
			loginUserDao.save(loginform);
			
			
		}
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		Optional<LoginForm> byUsername=loginUserDao.findByUsername(username);
		
		LoginForm loginform=byUsername.orElseThrow(()->new UsernameNotFoundException("USER DOES NOT EXIST"));
		
	     return User.withUsername(loginform.getUsername()).password(loginform.getPassword()).build();
	}
	

}
