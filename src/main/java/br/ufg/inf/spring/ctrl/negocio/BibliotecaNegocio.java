package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.excecao.BibliotecaException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.model.entidades.Biblioteca;
import br.ufg.inf.spring.model.entidades.Cidade;
import br.ufg.inf.spring.model.repositorio.BibliotecaRepositorio;
import br.ufg.inf.spring.model.repositorio.CidadeRepositorio;

@Service
public class BibliotecaNegocio {
	
	@Autowired
	private BibliotecaRepositorio repositorio;
	
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	public List<Biblioteca> findAll(){
		return repositorio.findAll();
	}
	
	public Biblioteca findById(Integer id) throws NotFoundException {
		Optional<Biblioteca> retorno = repositorio.findById(id);
		if(!retorno.isPresent()) {
			throw new NotFoundException("Biblioteca com id "+id+" não encontrada");
		}
		return retorno.get();

	}
	
	public Biblioteca insert(Biblioteca biblioteca) throws BibliotecaException {
		return this.insertOrUpdate(biblioteca);
	}
	
	private Biblioteca insertOrUpdate(Biblioteca biblioteca) throws BibliotecaException {
		
		if(biblioteca.getNomeBiblioteca().length() == 0 || biblioteca.getEndereco().length() == 0) {
			throw new BibliotecaException("Campo(s) Faltando");
		}
		
		return repositorio.save(biblioteca);
	}
	
	public void delete(Integer id) throws NotFoundException {
		Optional<Biblioteca> biblioteca = repositorio.findById(id);
		if(biblioteca.isPresent()) {
			repositorio.delete(biblioteca.get());
		}else {
			throw new NotFoundException("Biblioteca com id "+id+" não encontrada");
		}
	}
	
	
	public Biblioteca update(Biblioteca biblioteca) throws NotFoundException, BibliotecaException {
		Optional<Biblioteca> bUpd = repositorio.findById(biblioteca.getIdBiblioteca());
		// Atualizar os daddos no objeto
		if(!bUpd.isPresent()) {
			throw new NotFoundException("Biblioteca com id "+biblioteca.getIdBiblioteca()+" não encontrada");
		}else {
			Biblioteca bibliotecaUpd = bUpd.get();
			bibliotecaUpd.setNomeBiblioteca(biblioteca.getNomeBiblioteca());
			bibliotecaUpd.setEndereco(biblioteca.getEndereco());
			bibliotecaUpd.setCidade(biblioteca.getCidade());
			return this.insertOrUpdate(bibliotecaUpd);		
		}

	}
	
	public Biblioteca findByNome(String str) throws NotFoundException {
		List<Biblioteca> list = repositorio.findByNomeBiblioteca(str);
		if(list.size() > 0) {
			return list.get(0);
		}else {
			throw new NotFoundException("Biblioteca com nome '"+str+"' não encontrada");
		}
	}

	public List<Biblioteca> findAllNome(String str) throws NotFoundException {
		List<Biblioteca> list = repositorio.findByNomeBibliotecaContains(str);
		if(list.size() > 0) {
			return list;
		}else {
			throw new NotFoundException("Biblioteca com a ocorrência '"+str+"' não encontrada");
		}
	}
	public List<Biblioteca> findAllOrderNome(){
		return repositorio.findAllOrderNOme();
	}
	
	public List<Biblioteca> buscaPorCidade(Integer id) throws NotFoundException{
		Optional<Cidade> retorno = cidadeRepositorio.findById(id);
		if(!retorno.isPresent()) {
			throw new NotFoundException("Biblioteca com id "+id+" não encontrada");
		}
		return repositorio.findByCidade(retorno.get());
	}
	
}
