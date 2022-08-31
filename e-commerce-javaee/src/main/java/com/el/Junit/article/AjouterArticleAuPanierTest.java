package com.el.Junit.article;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.beans.Commande;
import com.el.beans.CommandeArticle;
import com.el.database.articles.ArticleDao;
import com.el.database.commandes.CommandeDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class AjouterArticleAuPanierTest {

	@Test
	void testAjouterArticleAuPanier() {
        DaoFactory daofFactory = DaoFactory.getInstance();
        CommandeDao commandeDao = daofFactory.getCommandeDao();
        ArticleDao articleDao = daofFactory.getArticleDao(); 
        try {
        	// recuperation d'une commande
			Commande commande = commandeDao.rechercherCommandeViaSonIdentifiant(7);
			// recuperation des articles
			Article article1 = articleDao.rechercherArticleViaSonIdentifiant(2);
			Article article2 = articleDao.rechercherArticleViaSonIdentifiant(3);
			Article article3 = articleDao.rechercherArticleViaSonIdentifiant(4);
			// ajoue des articles dans le panier
			boolean test = articleDao.ajouterArticleAuPanier(commande, article1, 2);
			assertEquals(true, test);
			test = articleDao.ajouterArticleAuPanier(commande, article2, 3);
			assertEquals(true, test);
			test = articleDao.ajouterArticleAuPanier(commande, article3, 4);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
        
	}

}
