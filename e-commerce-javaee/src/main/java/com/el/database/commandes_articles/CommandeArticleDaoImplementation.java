package com.el.database.commandes_articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.el.beans.Article;
import com.el.beans.Commande;
import com.el.beans.CommandeArticle;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class CommandeArticleDaoImplementation implements CommandeArticleDao {
	private DaoFactory daoFactory;

	public CommandeArticleDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// permette d'ajouter un article au panier , connaissant la commande et
	// l'article
	@Override
	public boolean ajouterArticleAuPanier(Commande commande, Article article, int quantite) throws DaoException {
		boolean ajoueAvecSucces = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO commandes_articles(idCommande,idArticle,quantite,prixTotal) VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, commande.getIdentifiant());
			preparedStatement.setInt(2, article.getIdentifiant());
			preparedStatement.setInt(3, quantite);
			preparedStatement.setInt(4, quantite * article.getPrixUnitaire());
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) { // s'il ya une erreur de type SQLException
			try {
				if (connection != null) {
					connection.rollback(); // annulation de la transaction
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					connection.close();
				}
			} catch (SQLException e1) {
			}
			throw new DaoException("impossible de communiquer avec la base de données");
		} finally { // si tout c'est bien passer
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				ajoueAvecSucces = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return ajoueAvecSucces;
	}

	// permette de supprimer un article au panier
	@Override
	public boolean supprimerArticleDuPanier(Article article) throws DaoException {
		boolean suppressionAvecSucces = false;

		return suppressionAvecSucces;
	}

	/*
	 * elle renvoie une liste de Map contenant les articles , leur quantite
	 * correspondant et le prix total correspondant
	 */
	@Override
	public List<Map<String, String>> facture(Commande commande) throws DaoException {
		List<Map<String, String>> factures = new ArrayList<Map<String, String>>();

		return factures;
	}

	// donne la somme total des articles acheter
	@Override
	public int totalFacture(Commande commande) throws DaoException {
		int totalFacture = 0;

		return totalFacture;
	}

	// renvoie la liste correspondant au article commander
	@Override
	public List<CommandeArticle> listCommandearticle(Commande commande) throws DaoException {
		List<CommandeArticle> commandeArticles = new ArrayList<CommandeArticle>();

		return commandeArticles;
	}

}
