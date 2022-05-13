package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.GuestEntity;
import com.mycompany.spring_mvc_project_final.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	GuestRepository guestRepository;
	
	public void save(GuestEntity guest) {
		guestRepository.save(guest);
	}
	
	public List<GuestEntity> findAll() {
		return (List<GuestEntity>) guestRepository.findAll();
	}
	
	public List<GuestEntity> findByBookingDetailId(int id) {
		return guestRepository.findByBookingDetailId(id);
	}

	public Optional<GuestEntity> findById(int id) {
		return guestRepository.findById(id);
	}

	public void deleteById(int id) {
		guestRepository.deleteById(id);
	}
	
}
