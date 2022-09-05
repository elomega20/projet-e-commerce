package com.el.servlet.commandes_articles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.beans.Commande;
import com.el.database.articles.ArticleDao;
import com.el.database.commandes.CommandeDao;
import com.el.database.commandes_articles.CommandeArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class AjouterArticleAuPanierTest {

	@Test
	void testAjouterArticleAuPanier() {
		DaoFactory daofFactory = DaoFactory.getInstance();
        CommandeDao commandeDao = daofFactory.getCommandeDao();
        ArticleDao articleDao = daofFactory.getArticleDao();
        CommandeArticleDao commandeArticleDao = daofFactory.getCommandeArticleDao(); 
        try {
        	// recuperation d'une commande
			Commande commande = commandeDao.rechercherCommandeViaSonIdentifiant(1);
			// recuperation des articles
			Article article1 = articleDao.rechercherArticleViaSonIdentifiant(2);
			Article article2 = articleDao.rechercherArticleViaSonIdentifiant(3);
			// ajoue des articles dans le panier
			boolean test = commandeArticleDao.ajouterArticleAuPanier(commande, article1, 2);
			assertEquals(true, test);
			test = commandeArticleDao.ajouterArticleAuPanier(commande, article2, 3);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
        
	}

}
