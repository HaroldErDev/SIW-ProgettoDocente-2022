package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.repository.BuffetRepository;

@Service
public class BuffetService {
	
	@Autowired
	private BuffetRepository buffetRepository;
	
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
	
}
