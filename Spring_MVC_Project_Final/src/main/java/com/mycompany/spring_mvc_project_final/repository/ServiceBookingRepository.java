package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;

@Repository
public interface ServiceBookingRepository extends CrudRepository<ServiceBookingEntity, Integer> {

	@Query(value = "select service_booking.id, service_booking.price, quantity, serviceBookingDate, booking_detail_id, service_id  from service_booking  join  booking_detail on  booking_detail.id = service_booking.booking_detail_id join booking on booking.id = booking_detail.booking_id	where booking.id = :id", nativeQuery = true)
	public List<ServiceBookingEntity> findServiceBookingByBookingId(@Param(value = "id") int id);
}
