package com.mycompany.spring_mvc_project_final.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.repository.ServiceRepository;


@Service
public class ServiceService {

	@Autowired
	ServiceRepository serviceRepository;

	public void save(ServiceEntity service) {
		service.setCreateDate(LocalDate.now());
		serviceRepository.save(service);
	}

	public List<ServiceEntity> findAll() {
		return (List<ServiceEntity>) serviceRepository.findAll();
	}

	public ServiceEntity findById(int id) {
		return serviceRepository.findById(id).orElse(null);
	}

	public void deleteById(int id) {
		serviceRepository.deleteById(id);
	}


	public List<ServiceEntity> findServiceByRoom(int id) {
		
		return serviceRepository.findServiceByRoom(id);
	}
}
