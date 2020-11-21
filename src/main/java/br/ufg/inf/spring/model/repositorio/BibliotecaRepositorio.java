package br.ufg.inf.spring.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufg.inf.spring.model.entidades.Biblioteca;
import br.ufg.inf.spring.model.entidades.Cidade;

public interface BibliotecaRepositorio extends JpaRepository<Biblioteca, Integer> {

	public List<Biblioteca> findByNomeBiblioteca(String nomeBiblioteca);
	public List<Biblioteca> findByNomeBibliotecaContains(String nomeBiblioteca);
	
	public List<Biblioteca> findByCidade(Cidade cidade);
	
	
	
	
	@Query(value = "SELECT b FROM Biblioteca b ORDER BY nomeBiblioteca")
	public List<Biblioteca> findAllOrderNOme();
	
}
