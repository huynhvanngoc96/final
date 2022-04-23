package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.RoomCategoryEntity;
import com.mycompany.spring_mvc_project_final.repository.RoomCategoryRepository;

@Service
public class RoomCategoryService {

	@Autowired
	RoomCategoryRepository roomcategoryRepository;

	public void save(RoomCategoryEntity roomCategory) {
		roomcategoryRepository.save(roomCategory);
	}

	public List<RoomCategoryEntity> findAll() {
		return (List<RoomCategoryEntity>) roomcategoryRepository.findAll();
	}

	public RoomCategoryEntity findById(int id) {
		return roomcategoryRepository.findById(id).orElse(null);
	}

	public void deleteById(int id) {
		roomcategoryRepository.deleteById(id);
	}
}
