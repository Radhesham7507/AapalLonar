package com.aapallonar.AapalLonar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aapallonar.AapalLonar.model.ContactForm;
import com.aapallonar.AapalLonar.model.GalleryImageForm;
import com.aapallonar.AapalLonar.model.HotelBookingForm;
import com.aapallonar.AapalLonar.model.SignupForm;
import com.aapallonar.AapalLonar.service.ContactFormService;
import com.aapallonar.AapalLonar.service.GalleryFormService;
import com.aapallonar.AapalLonar.service.HotelBookingService;
import com.aapallonar.AapalLonar.service.LoginCredentialsService;
import com.aapallonar.AapalLonar.service.SignupFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {
	
	private ContactFormService contactFormService;
	
	private SignupFormService signupFormService;
	
	private GalleryFormService galleryFormService; 
	
	private HotelBookingService hotelBookingService;
	
    private LoginCredentialsService loginCredentialsService;
	
	
	@Autowired
	public void setLoginCredentialsService(LoginCredentialsService loginCredentialsService) {
		this.loginCredentialsService = loginCredentialsService;
	}

	
	
	
    @Autowired
	public void setHotelBookingService(HotelBookingService hotelBookingService) {
		this.hotelBookingService = hotelBookingService;
	}


	@Autowired
    public void setGalleryFormService(GalleryFormService galleryFormService) {
		this.galleryFormService = galleryFormService;
	}


	@Autowired
	public void setSignupFormService(SignupFormService signupFormService) {
		this.signupFormService = signupFormService;
	}


	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}


	@GetMapping("/")
	public String lonarView()
	{
	     
		return "lonar";
	}
	
	@GetMapping("galleryphotos")
	public String galleryphotos(HttpServletRequest req,Model m)
	{
		List<GalleryImageForm> galleryphotos=galleryFormService.getAllPhotos();
		m.addAttribute("galleryphotos",galleryphotos);
		return "galleryphotos";
	}
	
	
	
	
	@GetMapping("gallery")
	public String galleryView()
	{
		return "gallery";
	} 
	
	@GetMapping("galleryinfo")
	public String galleryinfo()
	{
		return "galleryinfo";
	} 
	
	@GetMapping("daityinfo")
	public String gallerydaityinfo()
	{
		return "daityinfo";
	} 
	
	@GetMapping("gallerydharinfo")
	public String gallerydhar()
	{
		return "gallerydharinfo";
	}
	
	@GetMapping("shivatempleinfo")
	public String shivatemple()
	{
		return "shivatempleinfo";
	}
	
	@GetMapping("Kamaljadevitemple")
	public String Kamaljadevitemple()
	{
		return "Kamaljadevitemple";
	}
	
	@GetMapping("loginpage")
	public String loginpageview()
	{
		return "loginpage";
	}
	
	@PostMapping("loginpage")
	public String loginpageCredentials(
			
			@RequestParam("oldusername") String oldusername,
			@RequestParam("oldpassword") String oldpassword,
			
			RedirectAttributes redirectAttributes
			
			)
	{
		String result=loginCredentialsService.checkUserCredentials(oldusername, oldpassword);
		if(result.equals("SUCCESS"))
		{
			redirectAttributes.addFlashAttribute("message",result);
		}
		else
		{
			redirectAttributes.addFlashAttribute("message",result);
		}
		
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("hotels")
	public String hotelview()
	{
		return "hotels";
		
	}
	
	@GetMapping("hotelbooking")
	public String hotelbookingview(Model model)
	{
		model.addAttribute("hotelbookingform",new HotelBookingForm());
		return "hotelbooking";
	}
	
	@PostMapping("hotelbookingForm")
	public String hotelBookingForm(@Valid @ModelAttribute HotelBookingForm hotelBookingForm,
			BindingResult bindingResult ,RedirectAttributes redirectAttributes ,Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("bindingResult",bindingResult);
			return "hotelbooking";
		}else if(hotelBookingForm.getAdults()>4)
		{
			model.addAttribute("message","Total number of adults is exceed by 4");
			return "hotelbooking";
		}
		
		HotelBookingForm saveHotelBookingFormService=hotelBookingService.saveHotelBookingFormService(hotelBookingForm);
		
		if(saveHotelBookingFormService!=null)
		{
			redirectAttributes.addFlashAttribute("message","Booking Send Successfully!");
			
		}
		else {
			
			redirectAttributes.addFlashAttribute("message","Something Went Wong!");

		}
		
		return "redirect:/hotelbooking";
		
		
	}
	
	
	
    
   @GetMapping("contactMe")
   public String contactView(Model model)
   {
	   
	   model.addAttribute("contactForm",new ContactForm());
	   return "contact";
   }
   
   
   @PostMapping("contactform")
   public String contactForm( @Valid @ModelAttribute ContactForm contactForm,
		   BindingResult bindingResult ,RedirectAttributes redirectAttributes,Model model)
   {
	   if(bindingResult.hasErrors())
	   {
		   model.addAttribute("bindingResult",bindingResult);
		   return "contact";
	   }
	   
	ContactForm  saveContactFormService=  contactFormService.saveContactFormService(contactForm);
	   
	if(saveContactFormService!=null)
	{
		redirectAttributes.addFlashAttribute("message","Message Send Successfully!");
		
	}else
	{
		redirectAttributes.addFlashAttribute("message","Something Went Worng!");
	}
	   
	   return "redirect:/contactMe";
   }
   
   
   @GetMapping("signup")
	public String singuppage( Model model) {
		
	   model.addAttribute("signupForm",new SignupForm());
	   
		return "signup";
	}
   
   @PostMapping("signupform")
   public String signupForm( @Valid @ModelAttribute SignupForm signupForm,
		   BindingResult bindingResult, RedirectAttributes redirectAttributes ,Model model)
   {
	   if(bindingResult.hasErrors())
	   {
		   model.addAttribute("bindingResult",bindingResult);
		   return "signup";
	   }
	   SignupForm  saveSignupFormService= signupFormService.saveSignupFormService(signupForm);
	   
	   if(saveSignupFormService!=null)
	   {
		   redirectAttributes.addFlashAttribute("message"," Signup Successfully!");
	   }
	   else
	   {
		   redirectAttributes.addFlashAttribute("message","Something Went Worng!");
	   }
	  
	   
	   return "redirect:/signup";
	   
   }
}
