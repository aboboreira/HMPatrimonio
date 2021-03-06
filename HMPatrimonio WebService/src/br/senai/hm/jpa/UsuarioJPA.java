package br.senai.hm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

import br.senai.hm.dao.UsuarioDAO;
import br.senai.hm.modelo.Usuario;

@Repository
public class UsuarioJPA implements UsuarioDAO {
	@PersistenceContext
	EntityManager manager;
	

	public void inserir(Usuario u) {
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();
	//	manager.close();
	}
	public void alterar (Usuario u) {
		manager.getTransaction().begin();
		manager.merge(u);
		manager.getTransaction().commit();

	}

	public Usuario buscarId(Long id) {
		return manager.find(Usuario.class, id);
	}

	public List<Usuario> buscarTodos() {
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u", Usuario.class);
		return query.getResultList();
	}

	public void inativar(Usuario u) {
		manager.getTransaction().begin();
		u.setStatus(false);
		manager.merge(u);
		manager.getTransaction().commit();
	}
	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public Usuario acessar(String login, String senha){
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			List<Usuario> lista = query.getResultList();
			if (lista.size() == 0) {
				return null;
			}else {
				return lista.get(0);
			}
	}
	

}
