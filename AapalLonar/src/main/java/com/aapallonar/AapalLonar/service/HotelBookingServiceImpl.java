package com.aapallonar.AapalLonar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aapallonar.AapalLonar.dao.HotelBookingFormCurd;
import com.aapallonar.AapalLonar.model.HotelBookingForm;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {
	
 private HotelBookingFormCurd hotelBookingFormCurd;
 
    @Autowired
	public void setHotelBookingFormCurd(HotelBookingFormCurd hotelBookingFormCurd) {
	this.hotelBookingFormCurd = hotelBookingFormCurd;
}

	@Override
	public HotelBookingForm saveHotelBookingFormService(HotelBookingForm hotelBookingForm) {
		
		return hotelBookingFormCurd.save(hotelBookingForm);
	}

	@Override
	public List<HotelBookingForm> readAllBookingsService() {
		
		return hotelBookingFormCurd.findAll();
	}

	@Override
	public void deleteHotelBookingService(String id) {
		
		hotelBookingFormCurd.deleteById(id);
	}

}
