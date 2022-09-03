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
import com.el.database.images.ImageDao;
import com.el.database.images.ImageDaoImplementation;
import com.el.database.livraisons.LivraisonDao;
import com.el.database.livraisons.LivraisonDaoImplemantation;
import com.el.database.livreurs.LivreurDao;
import com.el.database.livreurs.LivreurDaoImplementation;
import com.el.database.payements.PayementDao;
import com.el.database.payements.PayementDaoImplementation;

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
		connection.setAutoCommit(false); // pour pouvoir gerer les transactions a la main
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

	// Récupération du Dao de la classe article
	public ImageDao getImageDao() {
		return new ImageDaoImplementation(this);
	}

	// Récupération du Dao de la classe livreur
	public LivreurDao getLivreurDao() {
		return new LivreurDaoImplementation(this);
	}

    // Récupération du Dao de la classe payement
    public PayementDao getPayementDao() {
    	return new PayementDaoImplementation(this);
    }
    
    // Récupération du Dao de la classe livraison
    public LivraisonDao getLivraisonDao() {
    	return new LivraisonDaoImplemantation(this);
    }
}
