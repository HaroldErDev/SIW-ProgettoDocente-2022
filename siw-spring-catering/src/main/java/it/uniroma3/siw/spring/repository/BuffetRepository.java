package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Buffet;

@Repository
public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	public Optional<Buffet> findByNome(String nome);
	
}
