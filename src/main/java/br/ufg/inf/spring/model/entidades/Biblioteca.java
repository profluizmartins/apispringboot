package br.ufg.inf.spring.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_biblioteca")
	private Integer idBiblioteca;

	@Column(name="nome_biblioteca")
	private String nomeBiblioteca;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	private String endereco;
	
	public Biblioteca() {
		
	}
	
	public Biblioteca(Integer idBiblioteca, String nomeBiblioteca, Cidade cidade, String endereco) {
		super();
		this.idBiblioteca = idBiblioteca;
		this.nomeBiblioteca = nomeBiblioteca;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public Integer getIdBiblioteca() {
		return idBiblioteca;
	}

	public void setIdBiblioteca(Integer idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public String getNomeBiblioteca() {
		return nomeBiblioteca;
	}

	public void setNomeBiblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Biblioteca [idBiblioteca=" + idBiblioteca + ", nomeBiblioteca=" + nomeBiblioteca + ", cidade=" + cidade
				+ ", endereco=" + endereco + "]";
	}
	
	
	
	
	
}
