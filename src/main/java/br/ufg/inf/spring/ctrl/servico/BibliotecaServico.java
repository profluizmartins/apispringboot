package br.ufg.inf.spring.ctrl.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.spring.ctrl.excecao.BibliotecaException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.ctrl.negocio.BibliotecaNegocio;
import br.ufg.inf.spring.model.entidades.Biblioteca;
@CrossOrigin
@RestController
@RequestMapping(value="/bibliotecas")
public class BibliotecaServico {
	
	@Autowired
	private BibliotecaNegocio negocio;
	
	@GetMapping
	public ResponseEntity<List<Biblioteca>> findAll() {
		
		List<Biblioteca> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Biblioteca> findById(@PathVariable Integer id){
		Biblioteca retorno = null;
		try {
			retorno = negocio.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);		
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Biblioteca> insert(@RequestBody Biblioteca biblioteca){
		try {
			biblioteca = negocio.insert(biblioteca);
			return ResponseEntity.status(HttpStatus.CREATED).body(biblioteca);
		} catch (BibliotecaException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(biblioteca);
		}
		//URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(biblioteca.getIdBiblioteca()).toUri();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		try {
			negocio.delete(id);
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Biblioteca> update(@PathVariable Integer id, @RequestBody Biblioteca biblioteca){
		try {
			biblioteca = negocio.update(biblioteca);
			return ResponseEntity.status(HttpStatus.CREATED).body(biblioteca);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(biblioteca);
		} catch (BibliotecaException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(biblioteca);
		}
		
	}
	
	@GetMapping(value="/nome/{str}")
	public ResponseEntity<Biblioteca> buscaPorNome(@PathVariable String str){
		Biblioteca biblioteca = null;
		try {
			biblioteca = negocio.findByNome(str);
			return ResponseEntity.status(HttpStatus.OK).body(biblioteca);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(biblioteca);		
		}
	}
	
	@GetMapping(value="/filtro/{str}")
	public ResponseEntity<List<Biblioteca>> FiltroPorNome(@PathVariable String str){
		List<Biblioteca> bibliotecas = null;
		try {
			bibliotecas = negocio.findAllNome(str);
			return ResponseEntity.status(HttpStatus.OK).body(bibliotecas);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bibliotecas);		
		}
	}
	

	@GetMapping(value="ordem")
	public ResponseEntity<List<Biblioteca>> findAllOrderNome() {
		
		List<Biblioteca> list = negocio.findAllOrderNome();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/cidade/{id}")
	public ResponseEntity<List<Biblioteca>> FiltroPorCidade(@PathVariable Integer id){
		List<Biblioteca> bibliotecas = null;
		try {
			bibliotecas = negocio.buscaPorCidade(id);
			return ResponseEntity.status(HttpStatus.OK).body(bibliotecas);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bibliotecas);		
		}
	}
}
