package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.entities.UserRoleEntity;
import com.mycompany.spring_mvc_project_final.repository.UserRepository;
import com.mycompany.spring_mvc_project_final.repository.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	UserRoleRepository userRoleRepository;
	
	public void save(UserRoleEntity userRole) {
		userRoleRepository.save(userRole);
	}
	
	public List<UserRoleEntity> findAll() {
		return (List<UserRoleEntity>) userRoleRepository.findAll();
	}
	
	/*
	 * public Optional<UserRoleEntity> findById(int id) { return
	 * userRoleRepository.findById(id); }
	 * 
	 * public void deleteById(int id) { userRoleRepository.deleteById(id); }
	 * 
	 * public List<UserRoleEntity> searchByName(String keyword) { return
	 * userRoleRepository.searchByName(keyword); }
	 */
}
