package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer>{

	@Query(value="select * \r\n"
			+ "from room join booking_detail on  room.id = booking_detail.room_id\r\n"
			+ "			join booking on booking.id = booking_detail.booking_id\r\n"
			+ "		where booking.id = :id")
	public List<RoomEntity> findRoomByBookingId(@Param(value = "id")int id);
}
