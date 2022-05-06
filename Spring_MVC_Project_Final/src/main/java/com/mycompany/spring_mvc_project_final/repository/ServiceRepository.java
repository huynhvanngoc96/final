package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Integer>{
	@Query(value = "SELECT service.name FROM service Join service_booking on service.id = service_booking.service_id JOIN booking_detail ON booking_detail.id = service_booking.booking_detail_id JOIN  booking ON booking.id = booking_detail.booking_id  JOIN room ON booking_detail.room_id = room.id  WHERE room.id = :id", nativeQuery = true)
	public List<ServiceEntity> findServiceByRoom(@Param(value = "id") int id);
	
}
