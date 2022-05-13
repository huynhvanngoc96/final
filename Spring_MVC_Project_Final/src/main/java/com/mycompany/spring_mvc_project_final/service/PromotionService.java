package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.repository.PromotionRepository;

@Service
public class PromotionService {

	@Autowired
	PromotionRepository promotionRepository;
	
	
	public void save(PromotionEntity promotion) {
		promotionRepository.save(promotion);
	}
	
	public List<PromotionEntity> findAll() {
		return (List<PromotionEntity>) promotionRepository.findAll();
	}
	
	public PromotionEntity findById(int id) {
		return promotionRepository.findById(id).orElse(null);
	}
	
	public void deleteById(int id) {
		promotionRepository.deleteById(id);
	}

	public List<PromotionEntity> searchByName(String search) {
		return promotionRepository.searchByName(search);	
	}
	  
}
