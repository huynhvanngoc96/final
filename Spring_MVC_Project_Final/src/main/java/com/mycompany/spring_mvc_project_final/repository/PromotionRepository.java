package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;

@Repository
public interface PromotionRepository extends CrudRepository<PromotionEntity, Integer>{

	@Query("select p from PromotionEntity p where p.name like %:keyword% ")
	public List<PromotionEntity> searchByName(@Param("keyword") String keyword);

}
