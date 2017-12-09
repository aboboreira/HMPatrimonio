package br.senai.hm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.senai.hm.dao.EmpresaDAO;
import br.senai.hm.modelo.Empresa;

@Repository
public class EmpresaJPA implements EmpresaDAO {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Empresa e) {
		manager.persist(e);
	}

	@Override
	public void alterar(Empresa e) {
		manager.merge(e);
}

	@Override
	public Empresa buscarId(Long id) {
		return manager.find(Empresa.class, id);
	}
}
