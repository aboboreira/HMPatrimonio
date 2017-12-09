package br.senai.hm.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.internal.util.xml.FilteringXMLEventReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;



//@Transactional
//@Controller
public class Teste {
	/*@Autowired
	@Qualifier("EmpresaJPA")
	private  EmpresaDAO dao;
	*/
	
	public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hm_patrimonio");
	EntityManager manager = factory.createEntityManager();
	 
	
		/*Empresa e = new Empresa();
		e.setCnpj("444444444.0001"); 
		e.setNome_fantasia("Senai Informática");
		
	//EmpresaJPA ej = new EmpresaJPA();
		
//		  ej.inserir(e);
		dao.inserir(e);
	*/
	}

}
