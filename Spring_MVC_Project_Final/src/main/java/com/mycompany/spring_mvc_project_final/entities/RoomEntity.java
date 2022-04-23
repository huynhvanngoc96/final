package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mycompany.spring_mvc_project_final.enums.RoomStatus;

@Entity
@Table(name = "room")
public class RoomEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "room_number", nullable = false)
	private String roomNumber;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoomStatus status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_category_id")
	private RoomCategoryEntity roomCategory;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<BookingDetailEntity> bookingDetail;
	
	public RoomEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public List<BookingDetailEntity> getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(List<BookingDetailEntity> bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public RoomCategoryEntity getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(RoomCategoryEntity roomCategory) {
		this.roomCategory = roomCategory;
	}
	
	
}
