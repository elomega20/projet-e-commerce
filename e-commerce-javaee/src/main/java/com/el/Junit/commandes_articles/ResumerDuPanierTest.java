package com.el.Junit.commandes_articles;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.CommandeArticle;
import com.el.database.commandes_articles.CommandeArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ResumerDuPanierTest {

	@Test
	void testResumerDuPanier() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CommandeArticleDao commandeArticleDao = daoFactory.getCommandeArticleDao();
        
        try {
			List<CommandeArticle> commandeArticles = commandeArticleDao.resumerDuPanier(1);
			for(CommandeArticle commandeArticle : commandeArticles) {
				System.out.println(commandeArticle.getIdentifiantCommande());
				System.out.println(commandeArticle.getIdentifiantArticle());
				System.out.println(commandeArticle.getQuantite());
				System.out.println(commandeArticle.getPrixTotal());
				System.out.println(commandeArticle.getNumeroPayement());
				System.out.println(commandeArticle.getIdentifiantLivraison());
				System.out.println();
			}
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
