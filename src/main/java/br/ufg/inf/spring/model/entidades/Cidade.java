package br.ufg.inf.spring.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cidade")
	private Integer idCidade;
	
	@Column(name="nome_cidade")
	private String nomeCidade;
	
	@Column(name="sigla_estado")
	private String siglaEstado;
	
	public Cidade(Integer idCidade, String nomeCidade, String siglaEstado) {
		super();
		this.idCidade = idCidade;
		this.nomeCidade = nomeCidade;
		this.siglaEstado = siglaEstado;
	}
	public Cidade() {
		
	}
	public Integer getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	@Override
	public String toString() {
		return "Cidade [idCidade=" + idCidade + ", nomeCidade=" + nomeCidade + ", siglaEstado=" + siglaEstado + "]";
	}
	
}
