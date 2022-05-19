package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Buffet;

@Repository
public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
}
