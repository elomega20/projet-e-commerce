package com.el.database.articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.el.beans.Article;
import com.el.beans.Categorie;
import com.el.beans.Commande;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class ArticleDaoImplementation implements ArticleDao {
	private DaoFactory daoFactory;

	// constructeur
	public ArticleDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// pour chaque categorie , on liste l'ensemble des articles
	@Override
	public  Map<String, List<Article>> consulterCatalogue() throws DaoException {
		// la cle correspond au categorie et la valeur correspond a la liste des articles associés
		 Map<String, List<Article>> catalogues = new HashMap<String, List<Article>>();
		 
		 CategorieDao categorieDao = daoFactory.getCategorieDao();
		 List<Categorie> categories = categorieDao.listerCategorie();
		 // pour chaque categorie , on met la liste des articles assoicés dans la Map
		 for (Categorie categorie : categories) {
			catalogues.put(categorie.getNom(), this.rechercherArticleViaSonCategorie(categorie));
		}

		return catalogues;
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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "SELECT * FROM articles WHERE idArticle=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, idArticle);
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			if (resultSet.next()) {
				article.setIdentifiant(resultSet.getInt("idArticle")); 
				article.setDesignation(resultSet.getString("designation"));
				article.setDetail(resultSet.getString("detail"));
				article.setPrixUnitaire(resultSet.getInt("prixUnitaire"));
				article.setStock(resultSet.getInt("stock"));
				article.setIdentifiantCategorie(resultSet.getInt("idCategorie"));
			}
		} catch (SQLException e) { // s'il ya une erreur de type SQLException
			try {
				if (connection != null) {
					connection.rollback(); // annulation de la transaction
					if (resultSet != null) {
						resultSet.close();
					}
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
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return article;
	}

	// recherche l'ensemble des articles liés a un categorie
	@Override
	public List<Article> rechercherArticleViaSonCategorie(Categorie categorie) throws DaoException {
		List<Article> articles = new ArrayList<Article>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "SELECT * FROM articles WHERE idCategorie=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, categorie.getIdentifiant());
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			while (resultSet.next()) {
				Article article = new Article();
				article.setIdentifiant(resultSet.getInt("idArticle")); 
				article.setDesignation(resultSet.getString("designation"));
				article.setDetail(resultSet.getString("detail"));
				article.setPrixUnitaire(resultSet.getInt("prixUnitaire"));
				article.setStock(resultSet.getInt("stock"));
				article.setIdentifiantCategorie(resultSet.getInt("idCategorie"));
				articles.add(article);
			}
		} catch (SQLException e) { // s'il ya une erreur de type SQLException
			try {
				if (connection != null) {
					connection.rollback(); // annulation de la transaction
					if (resultSet != null) {
						resultSet.close();
					}
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
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

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
	
	// supprimer un article dans la base
	@Override
	public boolean supprimerArticleDansLaBase(Article article) throws DaoException {
		boolean supprimerAvecScces = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "DELETE FROM articles WHERE idArticle=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, article.getIdentifiant());
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
				supprimerAvecScces = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}
       
		return supprimerAvecScces;
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
