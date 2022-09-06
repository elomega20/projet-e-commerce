package com.el.Junit.commandes_articles;

import org.junit.jupiter.api.Test;

import com.el.database.commandes_articles.CommandeArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class FactureTest {

	@Test
	void testFacture() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		CommandeArticleDao commandeArticleDao = daoFactory.getCommandeArticleDao();
		
		try {
			int facture = commandeArticleDao.facture(1);
			
			System.out.println(facture);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
