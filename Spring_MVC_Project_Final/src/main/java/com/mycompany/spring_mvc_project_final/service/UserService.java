package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void save(UserEntity user) {
		userRepository.save(user);
	}
	
	public List<UserEntity> findAll() {
		return (List<UserEntity>) userRepository.findAll();
	}
	
	public Optional<UserEntity> findById(int id) {
		return userRepository.findById(id);
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	public List<UserEntity> searchByName(String keyword) {
		return userRepository.searchByName(keyword);
	}
}
