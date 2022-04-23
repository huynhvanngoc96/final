package com.mycompany.spring_mvc_project_final.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.spring_mvc_project_final.enums.ServiceStatus;

@Entity
@Table(name = "service")
public class ServiceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Name is required")
	private String name;
	
	@Column(nullable = false, length = 2000)
	@NotBlank(message = "Description is required")
	private String description;
	
	@NotNull(message = "Price is required")
	@Column(nullable = false)
	private Double price;
	
	@NotNull(message = "Status is required")
	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
	private ServiceStatus status;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Open Time is required")
	private String openTime;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Open Time is required")
	private String location;
	
	@Column
	@CreatedDate
	private LocalDate createDate;
	
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	private List<ServiceBookingEntity> serviceBooking;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "service", cascade = CascadeType.ALL)
	private List<ImageEntity> imageEntities;
	
	@Transient
	private MultipartFile[] images;
	
	public ServiceEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ServiceStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceStatus status) {
		this.status = status;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


	public List<ServiceBookingEntity> getServiceBooking() {
		return serviceBooking;
	}

	public void setServiceBooking(List<ServiceBookingEntity> serviceBooking) {
		this.serviceBooking = serviceBooking;
	}

	public List<ImageEntity> getImageEntities() {
		return imageEntities;
	}

	public void setImageEntities(List<ImageEntity> imageEntities) {
		this.imageEntities = imageEntities;
	}

	public MultipartFile[] getImages() {
		return images;
	}

	public void setImages(MultipartFile[] images) {
		this.images = images;
	}
	
	
}
