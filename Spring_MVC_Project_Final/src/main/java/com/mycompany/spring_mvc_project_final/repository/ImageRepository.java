package com.mycompany.spring_mvc_project_final.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.ImageEntity;

@Repository
public interface ImageRepository extends CrudRepository<ImageEntity, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "delete from image where roomcategory_id = :categoryId and id = :id", nativeQuery = true)
	public void deleteImgCategory(@Param("categoryId") int categoryId, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from image where service_id = :serviceId and id = :id", nativeQuery = true)
	public void deleteImgService(@Param("serviceId") int categoryId, @Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from image where promotion_id = :promotionId and id = :id", nativeQuery = true)
	public void deleteImgPromotion(@Param("promotionId") int categoryId, @Param("id") int id);
}
