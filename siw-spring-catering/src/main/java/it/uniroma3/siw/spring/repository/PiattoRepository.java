package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Piatto;

@Repository
public interface PiattoRepository extends CrudRepository<Piatto, Long> {
	
	public Optional<Piatto> findByNome(String nome);
	
	public boolean existsByNome(String nome);
	
	public boolean existsByNomeAndIdNot(String nome, Long id);
	
	@Modifying
	@Query("update Piatto p set p.nome = :nome, p.descrizione = :descrizione where p.id = :id")
	public void updatePiatto(@Param("nome") String nome, @Param("descrizione") String descrizione, @Param("id") Long id);
	
}
