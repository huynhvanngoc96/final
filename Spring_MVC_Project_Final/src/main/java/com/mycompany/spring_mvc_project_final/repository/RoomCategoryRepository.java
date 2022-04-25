package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.RoomCategoryEntity;

@Repository
public interface RoomCategoryRepository extends CrudRepository<RoomCategoryEntity, Integer> {

	@Query(value = "select * from room_category "
			+ "where concat(id, bedInfo, capacity, createDate, description, name, price, size, status) like %?1%", nativeQuery = true)
	public List<RoomCategoryEntity> searchByName(String search);

}
