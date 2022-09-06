package com.el.Junit.commandes_articles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.database.commandes_articles.CommandeArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class PayerEnLigneTest {

	@Test
	void testPayerEnLigne() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CommandeArticleDao commandeArticleDao = daoFactory.getCommandeArticleDao();
        
        try {
			boolean test = commandeArticleDao.payerEnLigne(1, "772542316");
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
