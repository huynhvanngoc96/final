/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.RoomCategoryEntity;
import com.mycompany.spring_mvc_project_final.entities.UserEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByEmailLikeAndStatusLike(String email,
            UserStatus status);

    @Query(value = "select * from user "
			+ "where concat(address, fullName, email) like %?1%", nativeQuery = true)
	public List<UserEntity> searchByName(String search);
}
