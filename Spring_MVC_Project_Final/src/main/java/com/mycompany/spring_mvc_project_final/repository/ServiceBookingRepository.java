package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;

@Repository
public interface ServiceBookingRepository extends CrudRepository<ServiceBookingEntity, Integer> {

	@Query(value = "select *  from service_booking  join  booking_detail on  booking_detail.id = service_booking.booking_detail_id 	where booking_detail.id = :id", nativeQuery = true)
	public List<ServiceBookingEntity> findByBookingDetailId(@Param(value = "id") int id);
	/*
	 * @Query(value =
	 * "SELECT service_booking.quantity, service_booking.price FROM service_booking JOIN booking_detail ON booking_detail.id = service_booking.booking_detail_id JOIN  booking ON booking.id = booking_detail.booking_id  JOIN room ON booking_detail.room_id = room.id Join service on service.id = service_booking.service_id WHERE room.id = :id"
	 * , nativeQuery = true) public List<ServiceBookingEntity> findByRoom(int id);
	 */
	
	@Query(value = "Select * from service_booking where booking_detail_id = :bdId and service_id = :svId", nativeQuery = true)
	public Optional<ServiceBookingEntity> findByBookingDetailAndService(@Param(value = "bdId") int bdId, @Param(value = "svId") int svId);
}
