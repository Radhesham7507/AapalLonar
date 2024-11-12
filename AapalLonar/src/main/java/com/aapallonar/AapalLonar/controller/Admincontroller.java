package com.aapallonar.AapalLonar.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aapallonar.AapalLonar.model.GalleryImageForm;
import com.aapallonar.AapalLonar.service.ContactFormService;
import com.aapallonar.AapalLonar.service.GalleryFormService;
import com.aapallonar.AapalLonar.service.HotelBookingService;

import com.aapallonar.AapalLonar.service.SignupFormService;

@Controller
public class Admincontroller {
	
	private ContactFormService contactFormService;
	
	private SignupFormService signupFormService;
	
	private GalleryFormService galleryFormService;
	
	private HotelBookingService hotelBookingService;
	
	



	@Autowired
	public void setHotelBookingService(HotelBookingService hotelBookingService) {
		this.hotelBookingService = hotelBookingService;
	}




	@Autowired
	public void setSignupFormService(SignupFormService signupFormService) {
		this.signupFormService = signupFormService;
	}




	@Autowired
	public void setGalleryFormService(GalleryFormService galleryFormService) {
		this.galleryFormService = galleryFormService;
	}


	

	@Autowired	
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}


	@GetMapping("dashboard")
	public String dashboardView()
	{
		
		return "admin/Dashboard";
		
	} 
	
	@GetMapping("/admin/readAllContacts")
	public String readAllContacts(Model model)
	{
		
		model.addAttribute("allcontacts",contactFormService.readAllContactsService());
		
		return "admin/readallcontacts";
	}
	
	@GetMapping("/admin/deleteContact/{id}")
	public String deleteContacts(@PathVariable String id, RedirectAttributes redirectAttributes)
	{
		contactFormService.deleteContactService(id);
		redirectAttributes.addFlashAttribute("message","Contact Deleted Successfully!");
		return "redirect:/admin/readAllContacts";
	}
	
	
	@GetMapping("/admin/readAllSignups")
	public String readAllSignups(Model model)
	{
		model.addAttribute("allsignups",signupFormService.readAllSignupService());
		
		return "admin/readallsignups";
	}
	
	
	@GetMapping("/admin/deletesignup/{id}")
	public String deleteBookings(@PathVariable String id, RedirectAttributes redirectAttributes)
	{
		signupFormService.deleteSignup(id);
		redirectAttributes.addFlashAttribute("message","Signup Deleted Successfully!");
		return "redirect:/admin/readAllSignups";
	} 
	
	@GetMapping("admin/addgalleryphotos")
	public String addphotosview()
	{   
		return "admin/addgalleryphotos";
	}
	
	@InitBinder
	public void stopBinding(WebDataBinder webDataBinder)
	{
		webDataBinder.setDisallowedFields("image");
	}
	
	@PostMapping("admin/addgalleryphotos")
	public String galleryphotos(@ModelAttribute GalleryImageForm galleryImageForm,
			@RequestParam("image") MultipartFile multipartFile,RedirectAttributes redirectAttributes)
	{
		String origanalFilename=multipartFile.getOriginalFilename();
		galleryImageForm.setImage(origanalFilename);
		
		try {
			GalleryImageForm galleryphoto=galleryFormService.addphoto(galleryImageForm, multipartFile);
			if(galleryphoto!=null)
			{
				redirectAttributes.addFlashAttribute("message","Photo Added Successfully!");
				
			}else
			{
				
				redirectAttributes.addFlashAttribute("message","Something Went Worng");

			}
			
		} catch (Exception e) {
		
			redirectAttributes.addFlashAttribute("message","Something Went Worng");

			
		}
		
		return "redirect:/admin/addgalleryphotos";
		
	}
	
	@GetMapping("admin/readallphotos")
	public String readallphotosview(Model model)
	{
		model.addAttribute("allphotos",galleryFormService.readAllPhotos());
		
		return "admin/readallphotos";
	}
	
	@GetMapping("admin/deletephoto{id}")
	public String deletephotoview(@PathVariable String id,RedirectAttributes redirectAttributes)
	
	{
		galleryFormService.deletephoto(id);
		redirectAttributes.addFlashAttribute("message","Photo Deleted Successfully!");
		
		return "redirect:/admin/readallphotos";
	}
	
	
	@GetMapping("admin/readAllBookings")
	public String readAllHotelBookings(Model model)
	{
		model.addAttribute("allhotelbookings",hotelBookingService.readAllBookingsService());
		return "admin/readallbookings";
	}
	
	@GetMapping("admin/deleteHotelBooking/{id}")
	public String deleteHotelBookings(@PathVariable String id,RedirectAttributes redirectAttributes)
	{
		hotelBookingService.deleteHotelBookingService(id);
		redirectAttributes.addFlashAttribute("message","Booking Deleted Successfully!");
		return "redirect:/admin/readAllBookings";
	}
	
	
	
	
}
