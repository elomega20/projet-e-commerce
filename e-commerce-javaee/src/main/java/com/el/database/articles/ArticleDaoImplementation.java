package com.el.database.articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.el.beans.Article;
import com.el.beans.Categorie;
import com.el.beans.Commande;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class ArticleDaoImplementation implements ArticleDao {
	private DaoFactory daoFactory;

	// constructeur
	public ArticleDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// lister l'ensemble des artcles
	@Override
	public List<Article> consulterCatalogue() throws DaoException {
		List<Article> articles = new ArrayList<Article>();

		return articles;
	}

	// renvoie la liste des articles trouver
	@Override
	public List<Article> rechercherArticleParMotCle(String motCles) throws DaoException {
		List<Article> articles = new ArrayList<Article>();

		return articles;
	}

	// recherche et renvoi l'article trouver
	@Override
	public Article rechercherArticleViaSonIdentifiant(int idArticle) throws DaoException {
		Article article = new Article();

		return article;
	}

	// recherche l'ensemble des articles liés a un categorie
	@Override
	public List<Article> rechercherArticleViaSonCategorie(Categorie categorie) throws DaoException {
		List<Article> articles = new ArrayList<Article>();

		return articles;
	}

	// permette d'ajouter un article au panier
	@Override
	public boolean ajouterArticleAuPanier(Commande commande, Article article, int quantite) throws DaoException {
		boolean ajoueAvecSucces = false;

		return ajoueAvecSucces;
	}

	// permette de supprimer un article au panier
	@Override
	public boolean supprimerArticleDuPanier(Article article) throws DaoException {
		boolean suppressionAvecSucces = false;

		return suppressionAvecSucces;
	}

	// permette d'ajouter un article dans la base
	@Override
	public boolean ajouterArticleDansLaBase(Article article) throws DaoException {
		boolean ajoueAvecSucces = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO articles(designation,detail,prixUnitaire,stock,idCategorie) VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, article.getDesignation());
			preparedStatement.setString(2, article.getDetail());
			preparedStatement.setInt(3, article.getPrixUnitaire());
			preparedStatement.setInt(4, article.getStock());
			preparedStatement.setInt(5, article.getIdentifiantCategorie());
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

	// permette de mettre a jour le prix unitaire d'un article
	@Override
	public boolean mettreAjourPrixUnitaireArticle(Article article, int nouveauPrixUnitaire) throws DaoException {
		boolean miseAjourAvecSucces = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "UPDATE articles SET prixUnitaire=? WHERE idArticle=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, nouveauPrixUnitaire);
			preparedStatement.setInt(2, article.getIdentifiant());
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
				miseAjourAvecSucces = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return miseAjourAvecSucces;
	}

	// permette de mettre a jour le stock d'un article
	@Override
	public boolean mettreAjourStockArticle(Article article, int nouveauStock) throws DaoException {
		boolean miseAjourAvecSucces = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "UPDATE articles SET stock=? WHERE idArticle=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, nouveauStock);
			preparedStatement.setInt(2, article.getIdentifiant());
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
				miseAjourAvecSucces = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return miseAjourAvecSucces;
	}

}
