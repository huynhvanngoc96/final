package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	public void save(BookingEntity booking) {
		bookingRepository.save(booking);
	}
	
	public List<BookingEntity> findAll() {
		return (List<BookingEntity>) bookingRepository.findAll();
	}
	
	
	public BookingEntity findById(int id) {
		return bookingRepository.findById(id).orElse(null);
	}

	public List<BookingEntity> searchByName(String search) {
		return bookingRepository.searchByName(search);	
	}
	  
}
