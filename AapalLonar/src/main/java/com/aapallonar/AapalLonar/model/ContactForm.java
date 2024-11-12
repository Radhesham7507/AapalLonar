package com.aapallonar.AapalLonar.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactForm {
	
	@Id
	private String id;
	
	@NotEmpty(message="Name can not be Enpty")
	@Size(min=2,max=30,message="Invalid Name Size")
	private String name;
	
	@NotEmpty(message="Email can not be Empty")
	@Size(min=8,max=50,message="Invalid mail size")
	private String email;
	
	@NotEmpty(message="Phone No can not be Empty")
	@Size(min=10,message="Invalid Phone Number")
	private String phone;
	
	@NotEmpty(message="Message can not be Empaty")
	@Size(min=2,max=500,message="Invalid Message Size")
	private String message;

}
