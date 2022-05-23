package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ingrediente;
import com.example.demo.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente findIngredienteById(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
}
