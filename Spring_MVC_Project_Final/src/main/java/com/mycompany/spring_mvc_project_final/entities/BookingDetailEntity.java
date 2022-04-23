package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "booking_detail")
public class BookingDetailEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private double price;
	
	@Column
	private double discount;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private BookingEntity booking;
	
	@OneToMany(mappedBy = "bookingDetail", cascade = CascadeType.ALL)
	private List<ServiceBookingEntity> serviceBooking;
	
	@OneToMany(mappedBy = "bookingDetail", cascade = CascadeType.ALL)
	private List<GuestEntity> guest;
	
	public BookingDetailEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public BookingEntity getBooking() {
		return booking;
	}

	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}

	public List<GuestEntity> getGuest() {
		return guest;
	}

	public void setGuest(List<GuestEntity> guest) {
		this.guest = guest;
	}

	public List<ServiceBookingEntity> getServiceBooking() {
		return serviceBooking;
	}

	public void setServiceBooking(List<ServiceBookingEntity> serviceBooking) {
		this.serviceBooking = serviceBooking;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	
}

