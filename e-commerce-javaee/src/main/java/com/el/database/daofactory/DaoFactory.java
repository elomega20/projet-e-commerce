package com.el.database.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.el.database.articles.ArticleDao;
import com.el.database.articles.ArticleDaoImplementation;
import com.el.database.categories.CategorieDao;
import com.el.database.categories.CategorieDaoImplementation;
import com.el.database.clients.ClientDao;
import com.el.database.clients.ClientDaoImplementation;
import com.el.database.commandes.CommandeDao;
import com.el.database.commandes.CommandeDaoImplementation;


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

	// Récupération du Dao de la classe client
	public ClientDao getClientDao() {
		return new ClientDaoImplementation(this);
	}
	
	// Récupération du Dao de la classe commande
	public CommandeDao getCommandeDao() {
		return new CommandeDaoImplementation(this);
	}
	
	// Récupération du Dao de la classe categorie
	public CategorieDao getCategorieDao() {
		return new CategorieDaoImplementation(this);
	}
	
	// Récupération du Dao de la classe article
	public ArticleDao getArticleDao() {
		return new ArticleDaoImplementation(this);
	}
}
