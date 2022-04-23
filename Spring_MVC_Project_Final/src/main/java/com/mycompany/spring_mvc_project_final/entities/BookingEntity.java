package com.mycompany.spring_mvc_project_final.entities;

import java.time.LocalDate;
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

import org.springframework.data.annotation.CreatedDate;

import com.mycompany.spring_mvc_project_final.enums.BookingStatus;



@Entity
@Table(name = "booking") 
public class BookingEntity extends Personal{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(nullable = false)
	@CreatedDate
	private LocalDate bookingDate;
	
	@Column(nullable = false)
	private LocalDate checkIn;
	
	@Column(nullable = false)
	private LocalDate CheckOut;

	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private List<BookingDetailEntity> bookingDetail;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private List<PaymentEntity> paymentEntity;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	public BookingEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		CheckOut = checkOut;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}


	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<PaymentEntity> getPaymentEntity() {
		return paymentEntity;
	}

	public void setPaymentEntity(List<PaymentEntity> paymentEntity) {
		this.paymentEntity = paymentEntity;
	}

	public List<BookingDetailEntity> getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(List<BookingDetailEntity> bookingDetail) {
		this.bookingDetail = bookingDetail;
	}
	
	
	
}
