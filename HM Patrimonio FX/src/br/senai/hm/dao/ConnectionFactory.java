package br.senai.hm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {


		private final String USUARIO = "root";
		private final String SENHA = "root";
		private final String DRIVER = "com.mysql.jdbc.Driver";
		private final String URL = "jdbc:mysql://localhost/hm_patrimonio";
		
		public Connection getConnetion(){
			try {
				Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USUARIO, SENHA);
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}


	
	

