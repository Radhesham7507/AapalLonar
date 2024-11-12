package com.aapallonar.AapalLonar.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class LoginForm {

	
	
	@Id
	private String id;
	
	private String username;
	
	private String password;
	
}
