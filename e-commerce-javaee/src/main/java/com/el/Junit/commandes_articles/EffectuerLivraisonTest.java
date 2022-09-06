package com.el.Junit.commandes_articles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.database.commandes_articles.CommandeArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class EffectuerLivraisonTest {

	@Test
	void testEffectuerLivraison() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CommandeArticleDao commandeArticleDao = daoFactory.getCommandeArticleDao();
        
        try {
			boolean test = commandeArticleDao.effectuerLivraison(1, 1);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
