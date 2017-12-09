package br.senai.hm.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class Transferencia {
	@Id
	@GeneratedValue
	private Long id;
	private String motivo;
	private Calendar data;
	private String destivo;
	
	@OneToOne
	@JoinColumn(name = "id_ambiente")
	private Ambiente ambiente;
	
	@OneToOne
	@JoinColumn(name = "id_patrimonio")
	private Patrimonio patrimonios;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getDestivo() {
		return destivo;
	}
	public void setDestivo(String destivo) {
		this.destivo = destivo;
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	public Patrimonio getPatrimonios() {
		return patrimonios;
	}
	public void setPatrimonios(Patrimonio patrimonios) {
		this.patrimonios = patrimonios;
	}
	
	
	
}
