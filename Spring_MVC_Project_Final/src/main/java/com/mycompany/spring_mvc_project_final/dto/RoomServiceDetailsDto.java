package com.mycompany.spring_mvc_project_final.dto;

public class RoomServiceDetailsDto {
	
	private String serviceName;
	
	private int serviceBookingPrice;
	
	private Integer serviceBookingQuantity;

	public RoomServiceDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomServiceDetailsDto(String serviceName, int serviceBookingPrice, Integer serviceBookingQuantity) {
		super();
		this.serviceName = serviceName;
		this.serviceBookingPrice = serviceBookingPrice;
		this.serviceBookingQuantity = serviceBookingQuantity;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServiceBookingPrice() {
		return serviceBookingPrice;
	}

	public void setServiceBookingPrice(int serviceBookingPrice) {
		this.serviceBookingPrice = serviceBookingPrice;
	}

	public Integer getServiceBookingQuantity() {
		return serviceBookingQuantity;
	}

	public void setServiceBookingQuantity(Integer serviceBookingQuantity) {
		this.serviceBookingQuantity = serviceBookingQuantity;
	}
	
	
	
}
