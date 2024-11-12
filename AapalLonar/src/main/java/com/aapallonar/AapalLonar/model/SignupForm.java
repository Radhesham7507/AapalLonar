package com.aapallonar.AapalLonar.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
public class SignupForm {
	
	
	@Id
	private String id;
	
	@NotEmpty(message="Name can not be Enpty")
	@Size(min=2,max=30,message="Invalid Name Size")
	private String name;
	
	@NotEmpty(message="Email can not be Empty")
	@Size(min=8,max=50,message="Invalid mail size")
	private String email;
	
	@NotEmpty(message="Password can not be Empty")
	@Size(min=8,max=50,message="Invalid password size")
	private String password;
	
	@NotEmpty(message="Password can not be Empty")
	@Size(min=8,max=50,message="Invalid password size")
	private String cpassword;
	
	

}
