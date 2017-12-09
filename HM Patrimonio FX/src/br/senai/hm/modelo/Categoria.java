package br.senai.hm.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private int vida_util;
	private double depreciacao;
	private boolean status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getVida_util() {
		return vida_util;
	}
	public void setVida_util(int vida_util) {
		this.vida_util = vida_util;
	}
	public double getDepreciacao() {
		return depreciacao;
	}
	public void setDepreciacao(double depreciacao) {
		this.depreciacao = depreciacao;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
}
