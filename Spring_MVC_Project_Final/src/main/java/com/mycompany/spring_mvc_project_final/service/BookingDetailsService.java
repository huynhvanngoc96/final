package com.mycompany.spring_mvc_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.repository.BookingDetailsRepository;

@Service
public class BookingDetailsService {

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;
	

	public void save(BookingDetailEntity bookingDetails) {
		bookingDetailsRepository.save(bookingDetails);
	}
	
	public List<BookingDetailEntity> findAll() {
		return (List<BookingDetailEntity>) bookingDetailsRepository.findAll();
	}
}
