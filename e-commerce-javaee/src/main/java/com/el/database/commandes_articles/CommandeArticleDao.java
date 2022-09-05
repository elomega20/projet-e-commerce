package com.el.database.commandes_articles;

import java.util.List;
import java.util.Map;

import com.el.beans.Article;
import com.el.beans.Commande;
import com.el.beans.CommandeArticle;
import com.el.exceptions.DaoException;

public interface CommandeArticleDao {
	public boolean ajouterArticleAuPanier(Commande commande, Article article, int quantite) throws DaoException;

	public boolean supprimerArticleDuPanier(int idCommande,int idArticle) throws DaoException;

	List<Map<String, String>> facture(Commande commande) throws DaoException;

	int totalFacture(Commande commande) throws DaoException;

	public List<CommandeArticle> listCommandearticle(Commande commande) throws DaoException;
}
