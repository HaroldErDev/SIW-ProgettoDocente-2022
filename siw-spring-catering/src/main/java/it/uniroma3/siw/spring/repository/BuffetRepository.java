package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Buffet;

@Repository
public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	public Optional<Buffet> findByNome(String nome);
	
	public boolean existsByNomeAndDescrizione(String nome, String descrizione);
	
	@Modifying
	@Query("update Buffet b set b.nome = :nome, b.descrizione = :descrizione where b.id = :id")
	public void updateBuffet(@Param("nome") String nome, @Param("descrizione") String descrizione, @Param("id") Long id);
	
}
