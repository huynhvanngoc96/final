package com.mycompany.spring_mvc_project_final.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "guest")
public class GuestEntity extends Personal{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(nullable = false, length = 20)
	private String idCard;

	@ManyToOne
	@JoinColumn(name = "booking_detail_id")
	private BookingDetailEntity bookingDetail;
	
	
	public GuestEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public BookingDetailEntity getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(BookingDetailEntity bookingDetail) {
		this.bookingDetail = bookingDetail;
	}



}

