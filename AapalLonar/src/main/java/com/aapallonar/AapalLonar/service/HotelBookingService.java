package com.aapallonar.AapalLonar.service;

import java.util.List;

import com.aapallonar.AapalLonar.model.HotelBookingForm;

public interface HotelBookingService {
	
	public HotelBookingForm saveHotelBookingFormService(HotelBookingForm hotelBookingForm);
	
	public List<HotelBookingForm> readAllBookingsService();
	
	public void deleteHotelBookingService(String id);

}
