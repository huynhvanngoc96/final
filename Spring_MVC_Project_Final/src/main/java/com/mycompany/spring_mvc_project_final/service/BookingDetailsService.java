package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.repository.BookingDetailsRepository;

@Service
public class BookingDetailsService {

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;
	
	@Autowired
	ServiceBookingService serviceBookingService;
	

	public void save(BookingDetailEntity bookingDetails) {
		bookingDetailsRepository.save(bookingDetails);
	}
	
	public List<BookingDetailEntity> findAll() {
		return (List<BookingDetailEntity>) bookingDetailsRepository.findAll();
	}
	
	public List<BookingDetailEntity> findByBookingId(int id) {
		return bookingDetailsRepository.findByBookingId(id);
	}
	
	public BookingDetailEntity findbyId(int id) {
		return bookingDetailsRepository.findById(id).orElse(null);
	}

	public void deleteServiceBooking(int serviceBookingid, int bookingDetailId) {
		
		Optional<ServiceBookingEntity> opt_serviceBooking = serviceBookingService.findById(serviceBookingid);
		
		if (opt_serviceBooking.isPresent()) {
			ServiceBookingEntity svBooking = opt_serviceBooking.get();
			svBooking.setBookingDetail(null);			
			serviceBookingService.save(svBooking);
			serviceBookingService.deleteById(serviceBookingid);
		}
		
	}
}
