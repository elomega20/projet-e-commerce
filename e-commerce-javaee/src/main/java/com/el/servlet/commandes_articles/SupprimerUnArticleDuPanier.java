package com.el.servlet.commandes_articles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.database.commandes_articles.CommandeArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class SupprimerUnArticleDuPanier {

	@Test
	void testSupprimerArticleDuPanier() {
		DaoFactory daofFactory = DaoFactory.getInstance();
		CommandeArticleDao commandeArticleDao = daofFactory.getCommandeArticleDao(); 
		try {
			boolean test = commandeArticleDao.supprimerArticleDuPanier(1, 2);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
