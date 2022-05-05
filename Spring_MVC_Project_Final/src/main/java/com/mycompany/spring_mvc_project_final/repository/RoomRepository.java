package com.mycompany.spring_mvc_project_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.RoomEntity;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer>{

	@Query(value = "select room.id, room_number, room.status, room_category_id from room  join booking_detail on  room.id = booking_detail.room_id join booking on booking.id = booking_detail.booking_id	where booking.id = :id", nativeQuery = true)
	public List<RoomEntity> findRoomByBookingId(@Param(value = "id") int id);
}
