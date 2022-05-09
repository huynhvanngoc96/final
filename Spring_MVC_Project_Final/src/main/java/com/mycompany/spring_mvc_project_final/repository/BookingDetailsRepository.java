package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;

@Repository
public interface BookingDetailsRepository extends CrudRepository<BookingDetailEntity, Integer>{

	@Query(value = "select *  from booking_detail  join booking on booking.id = booking_detail.booking_id	where booking.id = :id", nativeQuery = true)
	public List<BookingDetailEntity> findByBookingId(@Param(value = "id") int id);
}
