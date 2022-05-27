package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.repository.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	private ChefRepository chefRepository;
	
	@Transactional
	public void save(Chef chef) {
		this.chefRepository.save(chef);
	}
	
	public List<Chef> findAllChef() {
		List<Chef> chef = new ArrayList<>();
		
		for(Chef c: chefRepository.findAll()) {
			chef.add(c);
		}
		
		return chef;
	}
	
	public Chef findChefById(Long id) {
		return chefRepository.findById(id).get();
	}
	
	public boolean alreadyExists(Chef chef) {
		return this.chefRepository.existsByNomeAndCognomeAndNazionalita(chef.getNome(), chef.getCognome(), chef.getNazionalita());
	}
	
	@Transactional
	public void deleteChef(Chef chef) {
		this.chefRepository.delete(chef);
	}
	
}
