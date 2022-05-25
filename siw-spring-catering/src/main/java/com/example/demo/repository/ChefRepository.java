package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chef;

@Repository
public interface ChefRepository extends CrudRepository<Chef, Long> {
	
	public boolean existsByNomeAndCognomeAndNazionalita(String nome, String cognome, String nazionalita);
	
}
