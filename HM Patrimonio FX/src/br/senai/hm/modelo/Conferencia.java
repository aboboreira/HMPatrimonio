package br.senai.hm.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Conferencia {
	@Id
	@GeneratedValue
	private Long id;
	private Calendar data;
	
	@OneToOne
	@JoinColumn(name = "id_agendamento")
	private Agendamento agendamento;
	
	
	@ManyToMany
	@JoinColumn(name = "patrimonio_ausente")
	private List<Patrimonio> patrimonio_ausente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	
	public List<Patrimonio> getPatrimonio_ausente() {
		return patrimonio_ausente;
	}

	public void setPatrimonio_ausente(List<Patrimonio> patrimonio_ausente) {
		this.patrimonio_ausente = patrimonio_ausente;
	}
	
	
	
	
}
