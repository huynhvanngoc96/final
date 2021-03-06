package com.mycompany.spring_mvc_project_final.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "service_booking")
public class ServiceBookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private int price;
	
	@Column
	private int quantity;
	
	@Column
	@CreatedDate
	private LocalDate serviceBookingDate;
	
	@ManyToOne
	@JoinColumn(name = "booking_detail_id")
	private BookingDetailEntity bookingDetail;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private ServiceEntity service;
	
	public ServiceBookingEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getServiceBookingDate() {
		return serviceBookingDate;
	}

	public void setServiceBookingDate(LocalDate serviceBookingDate) {
		this.serviceBookingDate = serviceBookingDate;
	}

	public BookingDetailEntity getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(BookingDetailEntity bookingDetail) {
		this.bookingDetail = bookingDetail;
	}

	public ServiceEntity getService() {
		return service;
	}

	public void setService(ServiceEntity service) {
		this.service = service;
	}
	
	
}
