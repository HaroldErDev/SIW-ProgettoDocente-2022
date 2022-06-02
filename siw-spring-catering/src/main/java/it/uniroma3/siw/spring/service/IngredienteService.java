package it.uniroma3.siw.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Ingrediente;
import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente findIngredienteById(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Ingrediente ingrediente, Piatto piatto) {
		piatto.addIngrediente(ingrediente);
		this.ingredienteRepository.save(ingrediente);
	}
	
	public boolean alreadyExists(Ingrediente ingrediente) {
		return this.ingredienteRepository.existsByNomeAndOrigine(ingrediente.getNome(), ingrediente.getOrigine());
	}
	
}