package com.el.database.commandes_articles;

import java.util.List;

import com.el.beans.Article;
import com.el.beans.Commande;
import com.el.beans.CommandeArticle;
import com.el.beans.Payement;
import com.el.exceptions.DaoException;

public interface CommandeArticleDao {
	public boolean ajouterArticleAuPanier(Commande commande, Article article, int quantite) throws DaoException;

	public boolean supprimerArticleDuPanier(int idCommande, int idArticle) throws DaoException;

	List<CommandeArticle> resumerDuPanier(int idCommande) throws DaoException;

	int facture(int idCommande) throws DaoException;

	boolean payerEnLigne(int idCommande, String idPayement) throws DaoException;

	boolean effectuerLivraison(int idCommande, int idLivraison) throws DaoException;
}
