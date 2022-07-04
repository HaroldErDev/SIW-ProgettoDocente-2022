package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Ingrediente;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	
	public boolean existsByNomeAndOrigineAndDescrizione(String nome, String origine, String descrizione);
	
}
