package com.mycompany.spring_mvc_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.repository.ServiceBookingRepository;

@Service
public class ServiceBookingService {

	@Autowired
	ServiceBookingRepository serviceBookingRepository;
	
	public void save(ServiceBookingEntity serviceBooking) {
		serviceBookingRepository.save(serviceBooking);
	}
	
	public List<ServiceBookingEntity> findAll() {
		return (List<ServiceBookingEntity>) serviceBookingRepository.findAll();
	}
	
	public List<ServiceBookingEntity> findByBookingDetailId(int id) {
		return serviceBookingRepository.findByBookingDetailId(id);
	}
	
	public ServiceBookingEntity findById(int id) {
		return serviceBookingRepository.findById(id).orElse(null);
	}


	
}
