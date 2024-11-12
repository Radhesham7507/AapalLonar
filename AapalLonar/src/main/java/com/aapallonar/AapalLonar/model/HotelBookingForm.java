package com.aapallonar.AapalLonar.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class HotelBookingForm {

	
	
	@Id
	private String id;
	
	@NotEmpty(message="Hotelchoice Cannot be Empty")
	private String hotelchoice;
	
	@NotEmpty(message="Title Cannot be Empty")
	private String title;
	
	@NotEmpty(message="Name Cannot be Empty")
	@Size(min=2,max=30,message="Invalid Name length")
	@NotBlank(message="name cant be blank")
	@Pattern(regexp = "^[A-Z a-z]+$" ,message="name must contain only alphabet")
	private String name;
	
	@NotNull(message="Date Cannot be Empty")
	private String checkin;
	
	@NotNull(message="Date Cannot be Empty")
	private String checkout;
	
	@Min(value=1,message="adult can be at least 1")
	@Max(value=4,message="adult can be at most 4")
	private int adults;
	
	@NotEmpty(message="Email Cannot be Empty")
	@Size(min=7,max=50,message="Invalid Email Size")
	@NotBlank(message="email cant be blank")
	private String email;
	
	@NotNull(message="Phone No Cannot be Empty")
	@Min(value=1000000000,message="Phone No must be at list 10 digits")
	@Max(value=9999999999L,message="Phone No must be at list 10 digits")
	private String phone;
	
	
}
