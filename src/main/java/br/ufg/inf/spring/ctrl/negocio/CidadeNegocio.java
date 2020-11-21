package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.model.entidades.Cidade;
import br.ufg.inf.spring.model.repositorio.CidadeRepositorio;

@Service
public class CidadeNegocio {
	
	@Autowired
	private CidadeRepositorio repositorio;
	
	public List<Cidade> findAllSimples(){
		return repositorio.findAll();
	}
	
	public Cidade findById(Integer id) {
		Optional<Cidade> retorno = repositorio.findById(id);
		return retorno.get();
	}
	
	public Cidade insert(Cidade cidade) {
		return repositorio.save(cidade);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	
	public Cidade update(Cidade cidade) {
		Cidade cidadeUpd = repositorio.getOne(cidade.getIdCidade());
		// Atualizar os daddos no objeto
		
		cidadeUpd.setNomeCidade(cidade.getNomeCidade());
		cidadeUpd.setSiglaEstado(cidade.getSiglaEstado());
		return repositorio.save(cidadeUpd);
	}
	
	
    public Page<Cidade> search(String searchTerm, int page, int size, String order, String active) {
        PageRequest pageRequest = PageRequest.of(
        		page, 
        		size, 
        		(order.contentEquals("desc")) ? Sort.Direction.DESC : Sort.Direction.ASC, 
        		active);
        return repositorio.search(searchTerm.toLowerCase(), pageRequest);
    }

    public Page<Cidade> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nomeCidade");
        return new PageImpl<>(repositorio.findAll(), pageRequest, size);
    }

}
