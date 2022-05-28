package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.repository.PiattoRepository;

@Service
public class PiattoService {
	
	@Autowired
	private PiattoRepository piattoRepository;
	
	@Transactional
	public void save(Piatto piatto, Buffet buffet) {
		buffet.addPiatto(piatto);
		this.piattoRepository.save(piatto);
	}
	
	public List<Piatto> findAllPiatti() {
		List<Piatto> piatti = new ArrayList<>();
		
		for(Piatto piatto : this.piattoRepository.findAll()) {
			piatti.add(piatto);
		}
		
		return piatti;
	}
	
	public Piatto findPiattoById(Long id) {
		return this.piattoRepository.findById(id).get();
	}
	
	@Transactional
	public void deletePiatto(Piatto piatto) {
		this.piattoRepository.delete(piatto);
	}
	
}
