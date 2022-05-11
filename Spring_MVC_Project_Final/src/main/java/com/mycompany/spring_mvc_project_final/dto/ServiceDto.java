package com.mycompany.spring_mvc_project_final.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mycompany.spring_mvc_project_final.enums.RoomStatus;

public class ServiceDto {
	
	@NotNull
	private Integer id;
	
	@NotNull
	private Double price;
	
	@NotNull
	private int quantity;

	public ServiceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	
	
	
	
}
