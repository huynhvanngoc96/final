package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.GuestEntity;

@Repository
public interface GuestRepository extends CrudRepository<GuestEntity, Integer> {
	

	@Query(value = "select *  from guest join  booking_detail on  booking_detail.id = guest.booking_detail_id 	where booking_detail.id = :id", nativeQuery = true)
	public List<GuestEntity> findByBookingDetailId(@Param(value = "id") int id);
}
