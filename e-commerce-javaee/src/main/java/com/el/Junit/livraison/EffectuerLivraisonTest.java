package com.el.Junit.livraison;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.beans.Livraison;
import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.database.livraisons.LivraisonDao;
import com.el.exceptions.DaoException;

class EffectuerLivraisonTest {

	@Test
	void testEffectuerLivraison() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		LivraisonDao livraisonDao = daoFactory.getLivraisonDao();
		
		Livraison livraison = new Livraison();
		livraison.setIdentifiantLivreur(1);
		livraison.setAdressDestination("grand dakar villa 44");

		try {
			boolean test = livraisonDao.effectuerLivraison(livraison);
			assertEquals(true, test);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

}
