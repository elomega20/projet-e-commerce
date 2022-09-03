package com.el.Junit.livraison;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Livraison;
import com.el.database.daofactory.DaoFactory;
import com.el.database.livraisons.LivraisonDao;
import com.el.exceptions.DaoException;

class LivraisonEffectuerTest {

	@Test
	void testLivraisonEffectuer() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        LivraisonDao livraisonDao = daoFactory.getLivraisonDao();
        
        try {
			List<Livraison> livraisons = livraisonDao.livraisonEffectuer();
			for (Livraison livraison : livraisons) {
				System.out.println(livraison.getIdentifiant());
				System.out.println(livraison.getAdressDestination());
				System.out.println(livraison.isLivraisonEffectuer());
				System.out.println(livraison.getIdentifiantLivreur());
				System.out.println();
			}
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
