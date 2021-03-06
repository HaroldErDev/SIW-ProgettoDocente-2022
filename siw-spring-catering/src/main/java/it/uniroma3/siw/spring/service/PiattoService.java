package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public void save(Piatto piatto) {
		this.piattoRepository.save(piatto);
	}
	
	@Transactional
	public void save(Piatto piatto, Buffet buffet) {
		buffet.addPiatto(piatto);
		this.piattoRepository.save(piatto);
	}
	
	@Transactional
	public void updatePiatto(Piatto editedPiatto) {
		this.piattoRepository.updatePiatto(editedPiatto.getNome(), editedPiatto.getDescrizione(), editedPiatto.getId());
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
	
	public boolean alreadyExists(Piatto piatto) {
		return this.piattoRepository.existsByNome(piatto.getNome());
	}
	
	public boolean alreadyExistsWithDifferentId(Piatto piatto) {
		return this.piattoRepository.existsByNomeAndIdNot(piatto.getNome(), piatto.getId());
	}
	
	public Piatto getPiattoByNome(String nome) {
		Optional<Piatto> piatto = this.piattoRepository.findByNome(nome);
		return piatto.orElse(null);
	}
	
}
