package br.senai.hm.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Patrimonio {
	@Id
	private Long id;
	private Calendar data_entrada;
	private Situacao situacao;
	private double valor_unitario;
	
	@OneToOne
	@JoinColumn(name = "id_ambiente")
	private Ambiente ambiente;
	
	@OneToOne
	@JoinColumn(name = "id_modelo")
	private Modelo modelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Calendar data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
			
}
