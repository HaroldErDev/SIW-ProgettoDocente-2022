package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Chef;

@Repository
public interface ChefRepository extends CrudRepository<Chef, Long> {
	
	public boolean existsByNomeAndCognomeAndNazionalitaAndImageUrl(String nome, String cognome, String nazionalita, String imageUrl);
	
}
