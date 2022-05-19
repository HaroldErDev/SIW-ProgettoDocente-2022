package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Piatto;

@Repository
public interface PiattoRepository extends CrudRepository<Piatto, Long> {
	
}
