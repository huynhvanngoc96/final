package com.mycompany.spring_mvc_project_final.entities;

import javax.persistence.Table;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "convenient")
public class ConvenientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "convenient")
    private Set<RoomCategoryEntity> roomCategory;
	
	public ConvenientEntity() {
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

	public Set<RoomCategoryEntity> getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(Set<RoomCategoryEntity> roomCategory) {
		this.roomCategory = roomCategory;
	}
	
	
}
