package com.mycompany.spring_mvc_project_final.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.spring_mvc_project_final.entities.RoomEntity;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer>{

}