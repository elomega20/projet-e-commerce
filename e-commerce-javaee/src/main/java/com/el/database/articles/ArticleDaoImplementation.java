package com.el.database.articles;

import java.util.ArrayList;
import java.util.List;

import com.el.beans.Article;
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

	// permette d'ajouter un article au panier
	@Override
	public boolean ajouterArticleAuPanier(Commande commande, Article article, int quantite) throws DaoException {
		boolean ajoueAvecSucces = false;
		
		return ajoueAvecSucces;
	}

	//  permette de supprimer un article au panier
	@Override
	public boolean supprimerArticleDuPanier(Article article) throws DaoException {
		boolean suppressionAvecSucces = false;
		
		return suppressionAvecSucces;
	}

	// permette d'ajouter un article dans la base
	@Override
	public boolean ajouterArticleDansLaBase(Article article) throws DaoException {
		boolean ajoueAvecSucces = false;
		
		return ajoueAvecSucces;
	}

	// permette de mettre a jour le prix unitaire d'un article
	@Override
	public boolean mettreAjourPrixUnitaireArticle(Article article, int nouveauPrixUnitaire) throws DaoException {
		boolean miseAjourAvecSucces = false;
		
		return miseAjourAvecSucces;
	}

	// permette de mettre a jour le stock d'un article
	@Override
	public boolean mettreAjourStockArticle(Article article, int nouveauStock) throws DaoException {
		boolean miseAjourAvecSucces = false;
		
		return miseAjourAvecSucces;
	}
}
