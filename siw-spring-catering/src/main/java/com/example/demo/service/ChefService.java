package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Chef;
import com.example.demo.repository.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	private ChefRepository chefRepository;
	
	public List<Chef> findAll() {
		List<Chef> chef = new ArrayList<>();
		
		for(Chef c: chefRepository.findAll()) {
			chef.add(c);
		}
		
		return chef;
	}
	
}
