package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Piatto;

@Repository
public interface PiattoRepository extends CrudRepository<Piatto, Long> {
	
	public Optional<Piatto> findByNome(String nome);
	
}
