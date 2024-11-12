package com.aapallonar.AapalLonar.service;

import java.util.List;

import com.aapallonar.AapalLonar.model.ContactForm;

public interface ContactFormService {
	
	public ContactForm saveContactFormService(ContactForm contactForm);

    public List<ContactForm> readAllContactsService();
	
	public void deleteContactService(String id);
}
