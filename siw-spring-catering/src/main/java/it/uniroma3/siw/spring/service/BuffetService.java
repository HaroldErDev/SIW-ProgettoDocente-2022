package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.repository.BuffetRepository;

@Service
public class BuffetService {
	
	@Autowired
	private BuffetRepository buffetRepository;
	
	@Transactional
	public void save(Buffet buffet, Chef chef) {
		buffet.setChef(chef);
		chef.addBuffet(buffet);
		this.buffetRepository.save(buffet);
	}
	
	@Transactional
	public void deleteBuffet(Buffet buffet) {
		this.buffetRepository.delete(buffet);
	}
	
	public Buffet findBuffetById(Long id) {
		return buffetRepository.findById(id).get();
	}
	
	public List<Buffet> findAllBuffet() {
		List<Buffet> buffet = new ArrayList<>();
		
		for(Buffet b : buffetRepository.findAll()) {
			buffet.add(b);
		}
		
		return buffet;
	}
	
	public Buffet getBuffet(String nome) {
		Optional<Buffet> buffet = this.buffetRepository.findByNome(nome);
		return buffet.orElse(null);
	}
	
}
