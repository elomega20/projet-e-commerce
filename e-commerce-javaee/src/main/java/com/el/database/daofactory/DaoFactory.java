package com.el.database.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.el.database.clients.ClientDao;
import com.el.database.clients.ClientDaoImplementation;


/* La DAO Factory permet d'initialiser 
 * le DAO en chargeant notamment les drivers nécessaires 
 * (ici un driver JDBC MySQL) et se connecte à la base de 
 * données.*/

public class DaoFactory {
	private String url;
	private String username;
	private String password;

	// constructeur
	DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	// charge le pilote et cree une instance
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}

		DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		return instance;
	}

	// cree une connection
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.setAutoCommit(false); //pour pouvoir gerer les transactions a la main
		return connection;
	}

	// Récupération du Dao
	public ClientDao getClientDao() {
		return new ClientDaoImplementation(this);
	}
}
