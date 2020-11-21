package br.ufg.inf.spring.model.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufg.inf.spring.model.entidades.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {

	 @Query("FROM Cidade c " +
	           "WHERE LOWER(c.nomeCidade) like %:searchTerm% " +
	           "OR LOWER(c.siglaEstado) like %:searchTerm%")
	 Page<Cidade> search(
	            @Param("searchTerm") String searchTerm, 
	            Pageable pageable);
}
