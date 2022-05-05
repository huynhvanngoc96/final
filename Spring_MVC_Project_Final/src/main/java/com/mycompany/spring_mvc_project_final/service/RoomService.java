package com.mycompany.spring_mvc_project_final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	public void save(RoomEntity room) {
		roomRepository.save(room);
	}

	public List<RoomEntity> findAll() {
		return (List<RoomEntity>) roomRepository.findAll();
	}

	public List<RoomEntity> findRoomByBookingId(int id) {
		return roomRepository.findRoomByBookingId(id);
	}

}
