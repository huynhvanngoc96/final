package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mycompany.spring_mvc_project_final.enums.PaymentStatus;


@Entity
@Table(name = "payment")
public class PaymentEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private LocalDate paymentDate;
	
	@Column
	private double amount;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private BookingEntity booking;
	
	@ManyToOne
	@JoinColumn(name = "creditcard_id")
	private CreditCardEntity creditCard;

	public PaymentEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public BookingEntity getBookingEntity() {
		return booking;
	}

	public void setBookingEntity(BookingEntity booking) {
		this.booking = booking;
	}

	public BookingEntity getBooking() {
		return booking;
	}

	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}

	public CreditCardEntity getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardEntity creditCard) {
		this.creditCard = creditCard;
	}

	
}
