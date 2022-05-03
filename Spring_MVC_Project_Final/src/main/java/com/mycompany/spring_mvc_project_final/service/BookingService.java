package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
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
	
	
	public Optional<BookingEntity> findById(int id) {
		return (Optional<BookingEntity>) bookingRepository.findById(id);
	}
	
	public List<RoomEntity> findRoomByBookingId(int id) {
		return bookingRepository.findRoomByBookingId(id);
	}
}
